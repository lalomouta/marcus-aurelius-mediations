package com.netvuvu.sql;

import com.netvuvu.meditations.Meditation;

import java.sql.*;

public class SelectMeditations {

    private static String dbURL = "jdbc:derby:C:\\git\\marco-aurelio-meds\\marcus-aurelius-db;create=false;user=derby;password=derby";
    private static String tableName = "tweets";
    private static String query = "";
    private static Connection connection = null;
    private static Statement stmt = null;
    private static Meditation meditation = null;

    private static void createConnection(){
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connection = DriverManager.getConnection(dbURL);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void selectTweet(){
        try{
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM "+tableName + " where wastweeted='false' ORDER BY id FETCH first row ONLY;");
            while(resultSet.next()){

                meditation.setMed_id(resultSet.getInt(1));
                meditation.setMed_txt(resultSet.getString(2));

            }

        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
