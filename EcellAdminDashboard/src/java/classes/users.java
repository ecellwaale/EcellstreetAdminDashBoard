/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author neal
 */
public class users extends person{
    int Phone;
    String Query,Eip,address,city,state,pin,country,code,block,addedip;
    Date Edate,addeddate;

    @Override
    public String toString() {
        return "users{" + "Phone=" + Phone + ", Query=" + Query + ", Eip=" + Eip + ", address=" + address + ", city=" + city + ", state=" + state + ", pin=" + pin + ", country=" + country + ", code=" + code + ", block=" + block + ", addedip=" + addedip + ", Edate=" + Edate + ", addeddate=" + addeddate + '}';
    }

    
    public users(int Id,String Name, String Password, String Email) {
        super();
    }

    

    public users() {
//        super(Name, Password, Email);
//        this.uid = uid;
//        this.Phone = Phone;
//        this.Query = Query;
//        this.Eip = Eip;
//        this.address = address;
//        this.city = city;
//        this.state = state;
//        this.pin = pin;
//        this.country = country;
//        this.code = code;
//        this.block = block;
//        this.addedip = addedip;
//        this.Edate = Edate;
//        this.addeddate = addeddate;
    }

   

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public String getQuery() {
        return Query;
    }

    public void setQuery(String Query) {
        this.Query = Query;
    }

    public String getEip() {
        return Eip;
    }

    public void setEip(String Eip) {
        this.Eip = Eip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getAddedip() {
        return addedip;
    }

    public void setAddedip(String addedip) {
        this.addedip = addedip;
    }

    public Date getEdate() {
        return Edate;
    }

    public void setEdate(Date Edate) {
        this.Edate = Edate;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

   

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    
    
}
