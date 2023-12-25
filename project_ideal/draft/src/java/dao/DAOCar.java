/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Car;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class DAOCar extends DBConnect {

    public Vector<Car> getCar(String sql) {
        Vector<Car> vector = new Vector<>();
        try {
            Statement state = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int CarID = rs.getInt("CarID");
                String CarOwner = rs.getString("CarOwner");
                int CarBrandID = rs.getInt("CarBrandID");
                String carName = rs.getString("carName");
                String ProductDescription = rs.getString("ProductDescription");
                int CarPricePerDay = rs.getInt("CarPricePerDay");
                String FuelType = rs.getString("FuelType");
                String CarLicense = rs.getString("CarLicense");

                vector.add(new Car(CarID, CarOwner,
                        CarBrandID, carName,
                        CarPricePerDay, FuelType,
                        CarLicense));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public void insertCar(Car c) {
        String sql = "INSERT INTO [dbo].[Car]\n"
                + "           ,([CarOwner]\n"
                + "           ,[CarBrandID]\n"
                + "           ,[CarName]\n"
                + "           ,[CarPricePerDay]\n"
                + "           ,[FuelType]\n"
                + "           ,[CarLicense])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            // pre.setDataType(indexOf?,para);
            pre.setString(1, c.getCarOwner());
            pre.setInt(2, c.getCarBrandID());
            pre.setString(3, c.getCarName());
            pre.setInt(4, c.getCarPricePerDay());
            pre.setString(5, c.getFuelType());
            pre.setString(6, c.getCarLicense());
            pre.executeUpdate();

        } catch (SQLException ex) {
        }
    }

}
