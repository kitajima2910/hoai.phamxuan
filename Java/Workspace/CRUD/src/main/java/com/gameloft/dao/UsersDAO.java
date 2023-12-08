/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.dao;

import com.gameloft.model.Users;
import com.gameloft.utils.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kitajima2910
 */
public class UsersDAO {
    
    public static List<Users> getAll() {
        List<Users> list = new ArrayList<>();
        
        try {
            String sql = "select * from users order by id desc";
            PreparedStatement ps = Database.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                long id = Long.valueOf(rs.getString("id"));
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                list.add(new Users(id, name, email, country, password));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public static boolean insert(Users users) {
        
        try {
            String sql = "INSERT INTO users(name, email, country, password) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = Database.getInstance().getConnection().prepareCall(sql);
            ps.setString(1, users.getName());
            ps.setString(2, users.getEmail());
            ps.setString(3, users.getCountry());
            ps.setString(4, users.getPassword());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public static void main(String[] args) {
//        System.out.println(UsersDAO.getAll().size());
        if(UsersDAO.insert(new Users("", "sany.wong@gmail.com", "Singapore", "123456"))) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    
}
