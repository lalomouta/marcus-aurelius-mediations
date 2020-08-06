package com.netvuvu.main;

import com.netvuvu.meditations.Meditation;
import com.netvuvu.file.File;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;


public class MarcoAurelioMeditations {
    public static void main (String[] args) throws TwitterException {
        Meditation todayMeditation = new Meditation();

        File fichero_txt = new File("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\paragraph-line-by-line.txt");
        String[] array_txt = fichero_txt.readLinesIntoArray()
        Integer id = 1;
        String med_text = id.toString() + ".- From my grandfather Verus I learned good morals and the government of my temper.\n From the reputation and remembrance of my father, modesty and a manly character.";
        //la longitud maxima de un tweet son 280 caracteres,
        // por eso la longitud del texto no debe superar 280 - longitud id (es un entero) - longitud(".- ")
        System.out.println(med_text.length());
        todayMeditation.setMed_id(id);
        System.out.println(med_text);
        todayMeditation.setMed_txt(med_text);

        ConfigurationBuilder conf = new ConfigurationBuilder().setDebugEnabled(true)
                .setOAuthConsumerKey("yh2IjA6mXk6qxjjfnyInmloxg")
                .setOAuthConsumerSecret("Z1xEoBs9v78Uqhs0YgzJr95u3tKwX1AzsgqzoV9FvNStKqLyoU")
                .setOAuthAccessToken("1290888645143154688-Frrxr6OWQxvWAkcSHzObU7p1uIbtOa")
                .setOAuthAccessTokenSecret("7v6ECgwoZb046x7AZU1NCZXedcPmU6tnf3jQp5EsfpZ0Y");

        TwitterFactory tf = new TwitterFactory(conf.build());
        Twitter twitter = tf.getInstance();
        Status status = twitter.updateStatus(todayMeditation.getMed_txt());
        System.out.println("Successfully updated the status to [" + status.getText() + "].");


    }
}
