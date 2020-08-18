package com.netvuvu.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;

public class InsertData {

    private static String dbURL = "jdbc:derby:C:\\git\\marco-aurelio-meds\\marcus-aurelius-db;create=false;user=derby;password=derby";
    private static String tableName = "tweets";
    private static String query = "";
    private static Connection connection = null;
    private static Statement stmt = null;

    private static void createConnection(){
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connection = DriverManager.getConnection(dbURL);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void insertTweet(Integer Id, String texto, String wasTweeted ){
        try{
            stmt = connection.createStatement();
            //String query = "INSERT INTO " + tableName + " VALUES (" +
            query = "INSERT INTO " + tableName + " VALUES (" +
                    Id.toString() + ",'" + texto + "', '" + wasTweeted + "')";
            stmt.execute(query);
            stmt.close();

        } catch (SQLException sqlException){
            System.out.println("Query que se ejecuta => " + query);
            sqlException.printStackTrace();
        }
    }

    private static void shutdownConnection(){
        try{
            if(stmt != null) { stmt.close();}
            if(connection != null ) {
                connection.close();
                DriverManager.getConnection(dbURL + ";shutdown=true");

            }
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    private static void readTweetsFromFiles(){
        String path = "C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\output";
        File folder = new File(path);
        Integer Id = 1;
        for (final File fileEntry :  folder.listFiles()){
            //System.out.println(fileEntry.getAbsolutePath());

            try {
                BufferedReader br = new BufferedReader(new FileReader(fileEntry));
                String tweet;

                while ((tweet = br.readLine()) != null) {
                    if(tweet.contains("'")){
                        tweet = tweet.replace("'","''");
                    }
                    insertTweet(Id, tweet, "false");
                    tweet = "";
                    Id++;
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args){
        createConnection();
        readTweetsFromFiles();
        shutdownConnection();
    }

}
