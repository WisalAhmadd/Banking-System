/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybanksystem;

/**
 *
 * @author Touseef Khattak
 */
public class City {
    String CityName , RegionName;
    
    public City(String CityName,String RegionName)
    {
        this.CityName = CityName;
        this.RegionName = RegionName;
    }
    public String toString()
    {
        return "\n City: "  + CityName + " \nReg: " + RegionName + " ";
    }
}
