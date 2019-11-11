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
    public void addBuyer(String...x) throws ClassNotFoundException{
        ArrayList list=new ArrayList();
        for(String y:x){
            list.add(y);
        }
         String sql = "INSERT INTO buyer VALUES (id,'" + list.get(0) + "','" + list.get(1) + "','" + list.get(2) + "','" + list.get(3)+  "')";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            System.out.println("successful");
        } catch (SQLException e) {
            System.out.println("sorry");
            System.out.println(e.getMessage());
        }
    }
    public void getAll() throws ClassNotFoundException{
        String sql = "SELECT * FROM `buyer`";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeQuery();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id2 = rs.getInt("id");
                String uss = rs.getString("fname");
                String pass = rs.getString("lname");

                System.out.format("%s, %s, %s\n", id2, uss, pass);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//    public void update(){
//        String sql = "UPDATE `buyer` SET `fname`='" +fname+ "',`lname`='" + lname + "',`celnum`='" + schedule + "'WHERE cour_id = ?";
//        try (Connection conn = this.connect();
//                PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
