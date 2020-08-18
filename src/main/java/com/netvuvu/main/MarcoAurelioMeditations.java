package com.netvuvu.main;

import com.netvuvu.meditations.Meditation;
import com.netvuvu.file.File;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.sql.*;
import java.util.List;


public class MarcoAurelioMeditations {

    private static String dbURL = "jdbc:derby:C:\\git\\marco-aurelio-meds\\marcus-aurelius-db;create=false;user=derby;password=derby";
    private static String tableName = "tweets";
    private static String query = "";
    private static Connection connection = null;
    private static Statement stmt = null;
    private static Meditation todayMeditation = new Meditation();

    public static void main (String[] args) throws TwitterException, IOException {



        //File fichero_txt = new File("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\paragraph-line-by-line.txt");
        //String[] array_txt = fichero_txt.readLinesIntoArray();

        createConnection();
        selectTweet();


        ConfigurationBuilder conf = new ConfigurationBuilder().setDebugEnabled(true)
                .setOAuthConsumerKey("yh2IjA6mXk6qxjjfnyInmloxg")
                .setOAuthConsumerSecret("Z1xEoBs9v78Uqhs0YgzJr95u3tKwX1AzsgqzoV9FvNStKqLyoU")
                .setOAuthAccessToken("1290888645143154688-Frrxr6OWQxvWAkcSHzObU7p1uIbtOa")
                .setOAuthAccessTokenSecret("7v6ECgwoZb046x7AZU1NCZXedcPmU6tnf3jQp5EsfpZ0Y");

        TwitterFactory tf = new TwitterFactory(conf.build());
        Twitter twitter = tf.getInstance();
        Status status = twitter.updateStatus(todayMeditation.getMed_txt());
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

        updateTweetedTweet();
        shutdownConnection();

    }

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
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM "+tableName + " where wastweeted='false' ORDER BY id FETCH first row ONLY");
            while(resultSet.next()){

                todayMeditation.setMed_id(resultSet.getInt(1));
                todayMeditation.setMed_txt(resultSet.getString(2));

            }
            resultSet.close();
            stmt.close();

        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    private static void updateTweetedTweet(){
        try{
            stmt = connection.createStatement();
            query = "UPDATE " + tableName + " set wastweeted='true' " +
                    " WHERE id =" + todayMeditation.getMed_id();

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
}
