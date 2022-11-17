/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import business.CountryCodeEnum;
import business.Parkolo;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import layout.ParkoloLayout;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author balaz
 */
public class ParkoloService {
    private JSONArray parkolok = new JSONArray();
    public JSONArray getAllParkolo(){
        getParkolokFromXml();
        return parkolok;
    }
    
    private JSONArray getParkolokFromXml(){
     
        //JSONArray parkolok = new JSONArray();
        parkolok = new JSONArray();
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File("files/beadando/ParkoloDB.xml");
            Document xml = builder.parse(f);
            xml.normalize();
            NodeList nodes = xml.getElementsByTagName("parkolo");
            for(int i = 0; i < nodes.getLength(); i++){
                Node node = nodes.item(i);
                
                Element data = (Element)node;
                Integer id = Integer.valueOf(data.getAttribute("id"));
                String name = data.getElementsByTagName("name").item(0).getTextContent();
                Integer maxParkingSpace = Integer.parseInt(data.getElementsByTagName("maxParkingSpace").item(0).getTextContent());
                Integer usedParkingSpace = Integer.parseInt(data.getElementsByTagName("usedParkingSpace").item(0).getTextContent());
                
                String cc = data.getElementsByTagName("cc").item(0).getTextContent();
                String postCode = data.getElementsByTagName("postCode").item(0).getTextContent();
                String city = data.getElementsByTagName("city").item(0).getTextContent();
                String street = data.getElementsByTagName("street").item(0).getTextContent();
                String buildingNumber = data.getElementsByTagName("buildingNumber").item(0).getTextContent();

                Parkolo p = new Parkolo(id, name, maxParkingSpace, usedParkingSpace, CountryCodeEnum.valueOf(cc), postCode, city, street, buildingNumber);
                parkolok.put(new ParkoloLayout(p.getId(), p.getName(), p.getFreeParkingSlot(), p.getAddress()).toJson());
            }
        }
        catch(Exception ex){
            parkolok.put(ex.toString());
        }
        return parkolok;
    }
    
    public JSONObject freeSpace(Integer id){
        getParkolokFromXml();
        
        JSONObject parkolo = new JSONObject();
        for (int i=0; i < parkolok.length(); i++) {
            JSONObject p = parkolok.getJSONObject(i);
            if(p.getInt("id")==id){
                return p;
            }
        }
        return null;
    }
    
}
