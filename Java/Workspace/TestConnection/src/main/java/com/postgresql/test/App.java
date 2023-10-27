package com.postgresql.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static List<Actor> listOfActors = new ArrayList<>();

    private static void getAllFirstName() {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;

        try {

            String sql = "select * from actor";
            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql);
            res = stm.executeQuery();

            while(res.next()) {
                int actorId = res.getInt("actor_id");
                String fistName = res.getString("first_name");
                String lastName = res.getString("last_name");
                String lastUpdate = res.getTimestamp("last_update").toString();
                Actor actor = new Actor(actorId, fistName, lastName, lastUpdate);
                listOfActors.add(actor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(cnt != null) {
                    cnt.close();
                }
                if(stm != null){
                    stm.close();
                }
                if(res != null) {
                    res.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        getAllFirstName();
        if(listOfActors.size() > 0) {
            listOfActors.forEach(System.out::println);
        }
    }

}
