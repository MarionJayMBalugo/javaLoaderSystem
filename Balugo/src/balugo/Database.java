/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balugo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 2ndyrGroupC
 */
public class Database {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/load";
    static final String USER = "root";
    static final String PASS = "";

    private Connection connect() throws ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void addBuyer(String... x) throws ClassNotFoundException {
        ArrayList list = new ArrayList();
        for (String y : x) {
            list.add(y);
        }
        String sql = "INSERT INTO buyer VALUES (id,'" + list.get(0) + "','" + list.get(1) + "','" + list.get(2) + "','" + list.get(3) + "')";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            System.out.println("successful");
        } catch (SQLException e) {
            System.out.println("sorry");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList getAll() throws ClassNotFoundException {
        ArrayList<ArrayList> tempList = new ArrayList();

        String sql = "SELECT * FROM `buyer`";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String id2 = rs.getString("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String celnum = rs.getString("celnum");
                String dept = rs.getString("dept");

                tempList.add(new ArrayList<>(Arrays.asList(id2, fname, lname, celnum, dept)));

            }
            System.out.println(tempList);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempList;
    }

    public ArrayList getAllByName(String name) throws ClassNotFoundException {
        ArrayList<ArrayList> tempList = new ArrayList();

        String sql = "SELECT * FROM `buyer` WHERE fname = '" + name + "'";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String id2 = rs.getString("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String celnum = rs.getString("celnum");
                String dept = rs.getString("dept");

                tempList.add(new ArrayList<String>(Arrays.asList(id2, fname, lname, celnum, dept)));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempList;
    }

    public ArrayList getAllByCompleteName(String fn, String ln) throws ClassNotFoundException {
        ArrayList<ArrayList> tempList = new ArrayList();

        String sql = "SELECT * FROM `buyer` WHERE fname = '" + fn + "' AND lname= '" + ln + "'";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String id2 = rs.getString("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String celnum = rs.getString("celnum");
                String dept = rs.getString("dept");

                tempList.add(new ArrayList<String>(Arrays.asList(id2, fname, lname, celnum, dept)));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempList;
    }

    public ArrayList getAllByNumber(String num) throws ClassNotFoundException {
        ArrayList<ArrayList> tempList = new ArrayList();

        String sql = "SELECT * FROM `buyer` WHERE celnum = '" + num + "'";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String id2 = rs.getString("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String celnum = rs.getString("celnum");
                String dept = rs.getString("dept");

                tempList.add(new ArrayList<String>(Arrays.asList(id2, fname, lname, celnum, dept)));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempList;
    }

    public void updateAll(String id, String fnUpdate, String lnUpdate, String nUpdate, String dUpdate) throws ClassNotFoundException {

        String sql = "UPDATE `buyer` SET `fname`='" + fnUpdate + "',`lname`='" + lnUpdate + "',`celnum`='" + nUpdate + "'WHERE id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.valueOf(id));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateAll(String id, String fnUpdate, String lnUpdate, String nUpdate, String dUpdate) throws ClassNotFoundException {

        String sql = "UPDATE `buyer` SET `fname`='" + fnUpdate + "',`lname`='" + lnUpdate + "',`celnum`='" + nUpdate + "'WHERE id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.valueOf(id));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
