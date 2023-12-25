/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class DAOUser extends DBConnect {

    public Vector<user> getUser(String sql) {
        Vector<user> vector = new Vector<>();
        try {
            Statement state = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int userID = rs.getInt("userID");
                String FullName = rs.getString("FullName");
                String Address = rs.getString("Address");
                String Phone = rs.getString("PhoneNumber");
                String userName = rs.getString("userName");
                String Password = rs.getString("Password");
                String CitizenID = rs.getString("CitizenID");
                int RoleID = rs.getInt("RoleID");
                int RenterID = rs.getInt("RenterID");

                user newuser = new user(userID, FullName, Address, Phone,
                        userName, Password, CitizenID, RoleID, RenterID);
                vector.add(newuser);
            }
        } catch (SQLException ex) {
        }
        return vector;
    }

    public user userLogin(String userName, String Password) {
        String sql = "Select  * from [user] where [UserName] = ? "
                + "and [Password] = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, userName);
            pre.setString(2, Password);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return new user(
                        rs.getInt("userID"),
                        rs.getString("FullName"),
                        rs.getString("Address"),
                        rs.getString("PhoneNumber"),
                        rs.getString("userName"),
                        rs.getString("Password"),
                        rs.getString("CitizenID"),
                        rs.getInt("RoleID"),
                        rs.getInt("RenterID")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public user checkAccountExist(String userName) {
        String sql = "Select  * from [user] where [userName] = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, userName);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return new user(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

//    public user userRegister(String userName, String FullName,
//            String Phone, String Address, String Password,
//            String ConfirmPassword) {
//        String sql = "INSERT INTO [dbo].[user]\n"
//                + "           ([FullName]\n"
//                + "           ,[Address]\n"
//                + "           ,[Phone]\n"
//                + "           ,[userName]\n"
//                + "           ,[Password]\n"
//                + "           ,[RoleID])\n"
//                + "     VALUES\n"
//                + "           (?\n"
//                + "           ,?\n"
//                + "           ,?\n"
//                + "           ,?\n"
//                + "           ,?\n"
//                + "           ,0)";
//        try {
//            PreparedStatement pre = connection.prepareStatement(sql);
//            pre.setString(1, FullName);
//            pre.setString(2, Address);
//            pre.setString(3, Phone);
//            pre.setString(4, userName);
//            pre.setString(5, Password);
//            pre.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
    public user getuserByID(int userID) {

        String sql = "select * from [user] where userID =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                user pro = new user(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)
                );
                return pro;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("null");
        return null;
    }

    public void updateUserRent(user user) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET [RenterID] = 1\n"
                + " WHERE UserID=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, user.getUserID());
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
//
//    public void deleteuserByuserID(int userID) {
//        String sql1 = "DELETE FROM [dbo].[user]\n"
//                + "      WHERE userID=" + userID;
//        try {
//            Statement state = connection.createStatement();
//            state.executeUpdate(sql1);
//        } catch (SQLException e) {
//        }
//    }

    public void insertuser(user u) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([UserName]\n"
                + "           ,[Password]\n"
                + "           ,[FullName]\n"
                + "           ,[PhoneNumber]\n"
                + "           ,[Address]\n"
                + "           ,[CitizenId]\n"
                + "           ,[RoleID])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, u.getUserName());
            pre.setString(2, u.getPassword());
            pre.setString(3, u.getFullName());
            pre.setString(4, u.getPhone());
            pre.setString(5, u.getAddress());
            pre.setString(6, u.getCitizenID());
            pre.setInt(7, u.getRoleID());
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//    public user getMaxuserID() {
//
//        String sql = "select top 1 * from [user] order by userID desc";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                user pro = new user(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getInt(7)
//                );
//                return pro;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        System.out.println("null");
//        return null;
//    }
}
