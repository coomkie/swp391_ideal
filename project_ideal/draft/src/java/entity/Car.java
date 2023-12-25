/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Car {

    /*create table Car(
CarID int primary key,
CarBrandID int,
CarName nvarchar(40),
CarPricePerDay int,
FuelType nvarchar(20),
CarLicense varchar(15)
)*/
    private int CarID;
    private String CarOwner;
    private int CarBrandID;
    private String carName;
    private int CarPricePerDay;
    private String FuelType;
    private String CarLicense;

    public Car(int CarID, String CarOwner, int CarBrandID, String carName, int CarPricePerDay, String FuelType, String CarLicense) {
        this.CarID = CarID;
        this.CarOwner = CarOwner;
        this.CarBrandID = CarBrandID;
        this.carName = carName;
        this.CarPricePerDay = CarPricePerDay;
        this.FuelType = FuelType;
        this.CarLicense = CarLicense;
    }

    public Car(String CarOwner, int CarBrandID, String carName, int CarPricePerDay, String FuelType, String CarLicense) {
        this.CarOwner = CarOwner;
        this.CarBrandID = CarBrandID;
        this.carName = carName;
        this.CarPricePerDay = CarPricePerDay;
        this.FuelType = FuelType;
        this.CarLicense = CarLicense;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" + "CarID=" + CarID + ", CarOwner=" + CarOwner + ", CarBrandID=" + CarBrandID + ", carName=" + carName + ", CarPricePerDay=" + CarPricePerDay + ", FuelType=" + FuelType + ", CarLicense=" + CarLicense + '}';
    }

    public int getCarID() {
        return CarID;
    }

    public void setCarID(int CarID) {
        this.CarID = CarID;
    }

    public String getCarOwner() {
        return CarOwner;
    }

    public void setCarOwner(String CarOwner) {
        this.CarOwner = CarOwner;
    }

    public int getCarBrandID() {
        return CarBrandID;
    }

    public void setCarBrandID(int CarBrandID) {
        this.CarBrandID = CarBrandID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarPricePerDay() {
        return CarPricePerDay;
    }

    public void setCarPricePerDay(int CarPricePerDay) {
        this.CarPricePerDay = CarPricePerDay;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String FuelType) {
        this.FuelType = FuelType;
    }

    public String getCarLicense() {
        return CarLicense;
    }

    public void setCarLicense(String CarLicense) {
        this.CarLicense = CarLicense;
    }

}
