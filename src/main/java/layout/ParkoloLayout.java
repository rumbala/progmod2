/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;

import org.json.JSONObject;

/**
 *
 * @author balaz
 */
public class ParkoloLayout {
    private Integer id;
    private String name;
    private Integer freeParkingSpace;
    private String address;

    public ParkoloLayout(Integer id, String name, Integer freeParkingSpace, String address) {
        this.id = id;
        this.name = name;
        this.freeParkingSpace = freeParkingSpace;
        this.address = address;
    }

    public JSONObject toJson(){
        JSONObject parkolo = new JSONObject();
        parkolo.put("id", this.id);
        parkolo.put("name", this.name);
        parkolo.put("freeParkingSpace", this.freeParkingSpace);
        parkolo.put("address", this.address);       
        return parkolo;
    }
}
