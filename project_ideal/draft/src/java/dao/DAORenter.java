/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Renter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class DAORenter extends DBConnect {

    public Vector<Renter> getRenter(String sql) {
        Vector<Renter> vector = new Vector<>();
        try {
            Statement state = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int RenterID = rs.getInt("RenterID");
                int CarID = rs.getInt("CarID");
                vector.add(new Renter(RenterID, CarID));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public void insertRenter(Renter rent) {
        String sql = "INSERT INTO [dbo].[Renter]\n"
                + "           ([CarID])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            // pre.setDataType(indexOf?,para);
            pre.setInt(1, rent.getCarID());

            pre.executeUpdate();

        } catch (SQLException ex) {
        }
    }
}
