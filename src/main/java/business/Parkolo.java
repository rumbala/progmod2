/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import org.json.JSONObject;

/**
 *
 * @author balaz
 */
public class Parkolo implements IParkolo{
    private Integer id;
    private String name;
    //parking space info
    private Integer maxParkingSpace;
    private Integer usedParkingSpace;
    //address
    private CountryCodeEnum cc;
    private String postCode;
    private String city;
    private String street;
    private String buildingNumber;

    public Parkolo(Integer id, String name, Integer maxParkingSpace, Integer usedParkingSpace, CountryCodeEnum cc, String postCode, String city, String street, String buildingNumber) {
        this.id = id;
        this.name = name;
        this.maxParkingSpace = maxParkingSpace;
        this.usedParkingSpace = usedParkingSpace;
        this.cc = cc;
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    public Parkolo(Integer id) {
        this.id = id;
    }
    
    //Interface overrides
    @Override
    public Boolean vehicleLeave(){
        if (this.usedParkingSpace >0){
            this.usedParkingSpace -= 1;
            return true;
        }
        return false;
    };
    @Override
    public Boolean vehicleEnter(){
        if (this.usedParkingSpace < this.maxParkingSpace){
            this.usedParkingSpace += 1;
            return true;
        }
        return false;
    };
    //Getter Functions
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMaxParkingSpace() {
        return maxParkingSpace;
    }

    public Integer getUsedParkingSpace() {
        return usedParkingSpace;
    }

    public CountryCodeEnum getCc() {
        return cc;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }
    //Calculating free space
    public Integer getFreeParkingSlot(){
        Integer freeParkingSlot = this.maxParkingSpace - this.usedParkingSpace;
        if (freeParkingSlot > 0){
            return freeParkingSlot;
        }
        return 0;
    }
    
    //other functions
    public void parkoloBovites(Integer plusSpace){
        this.maxParkingSpace += plusSpace;
    }
    public String getAddress()
    {
        return String.format("%s - %s %s %s %s", this.cc, this.postCode, this.city, this.street, this.buildingNumber);
    }
    
}
