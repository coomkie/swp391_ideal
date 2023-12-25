/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Renter {

    private int RenterID;
    private int CarID;

    public Renter() {
    }

    public Renter(int RenterID, int CarID) {
        this.RenterID = RenterID;
        this.CarID = CarID;
    }

    public int getRenterID() {
        return RenterID;
    }

    public void setRenterID(int RenterID) {
        this.RenterID = RenterID;
    }

    public int getCarID() {
        return CarID;
    }

    public void setCarID(int CarID) {
        this.CarID = CarID;
    }

    @Override
    public String toString() {
        return "Renter{" + "RenterID=" + RenterID + ", CarID=" + CarID + '}';
    }

}
