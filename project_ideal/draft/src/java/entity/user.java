/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author admin
 */
public class user {

    private int UserID;
    private String FullName;
    private String Address;
    private String Phone;
    private String UserName;
    private String Password;
    private String CitizenID;
    private int RoleID;
    private int RenterID;

    public user() {
    }

    public user(int UserID, String FullName, String Address, String Phone, String UserName, String Password, String CitizenID, int RoleID, int RenterID) {
        this.UserID = UserID;
        this.FullName = FullName;
        this.Address = Address;
        this.Phone = Phone;
        this.UserName = UserName;
        this.Password = Password;
        this.CitizenID = CitizenID;
        this.RoleID = RoleID;
        this.RenterID = RenterID;
    }

    public user(String FullName, String Address, String Phone, String UserName, String Password, String CitizenID, int RoleID) {
        this.FullName = FullName;
        this.Address = Address;
        this.Phone = Phone;
        this.UserName = UserName;
        this.Password = Password;
        this.CitizenID = CitizenID;
        this.RoleID = RoleID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCitizenID() {
        return CitizenID;
    }

    public void setCitizenID(String CitizenID) {
        this.CitizenID = CitizenID;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public int getRenterID() {
        return RenterID;
    }

    public void setRenterID(int RenterID) {
        this.RenterID = RenterID;
    }

    @Override
    public String toString() {
        return "user{" + "UserID=" + UserID + ", FullName=" + FullName + ", Address=" + Address + ", Phone=" + Phone + ", UserName=" + UserName + ", Password=" + Password + ", CitizenID=" + CitizenID + ", RoleID=" + RoleID + ", RenterID=" + RenterID + '}';
    }

}
