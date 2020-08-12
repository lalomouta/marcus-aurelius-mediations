package com.netvuvu.file;

import org.junit.jupiter.api.Test;
import com.netvuvu.file.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @Test
    public void testFile() throws IOException{
        File fichero_txt = new File("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\paragraph-line-by-line.txt");

        String[] array_txt = fichero_txt.readLinesIntoArray();

        Integer indice_fichero = 1;
        for (String line : array_txt) {

            Linea linea = new Linea(line);

            ArrayList<String> all_tweets = linea.substring(280,line);

            Integer indice_tweet=1;
            for(String tweet : all_tweets) {
                fichero_txt.writeToFile("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\output\\paragraph-line-by-line_" + indice_fichero.toString() +"_"+ indice_tweet.toString() + ".txt", tweet);

                indice_tweet++;
            }
            indice_fichero++;


        }


    }


    private class Test280 {

        String line="";
        String folder="";
        Integer indice_fichero = 1;
        public Test280(String linePar, String folderPar) {
            this.line = linePar;
            this.folder = folderPar;
        }

        public Test280(String linePar, String folderPar, Integer indicePar) {
            this.line = linePar;
            this.folder = folderPar;
            this.indice_fichero = indicePar;
        }


        public void run (){
            File fichero_txt = new File("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\paragraph-line-by-line.txt");

            Linea linea = new Linea(this.line);
            ArrayList<String> all_tweets = linea.substring(280,line);


            Integer indice_tweet=1;
            for(String tweet : all_tweets) {
                fichero_txt.writeToFile("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\"+folder+"\\paragraph-line-by-line_" + indice_fichero.toString() +"_"+ indice_tweet.toString() + ".txt", tweet);

                indice_tweet++;
            }
        }

        public void run (Integer indice){
            File fichero_txt = new File("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\paragraph-line-by-line.txt");

            Linea linea = new Linea(this.line);
            ArrayList<String> all_tweets = linea.substring(280,line);


            Integer indice_tweet=1;
            for(String tweet : all_tweets) {
                fichero_txt.writeToFile("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\"+folder+"\\paragraph-line-by-line_" + indice.toString() +"_"+ indice_tweet.toString() + ".txt", tweet);

                indice_tweet++;
            }
        }

    }

    @Test
    public void test_1(){
        Test280 test = new Test280("1", "output2");
        test.run();
    }

    @Test
    public void test_2(){
        Test280 test = new Test280("From my mother, piety and beneficence, and abstinence, not only from evil deeds, but even from evil thoughts; and further, simplicity in my way of living, far removed from the habits of the rich.  From my great-grandfather, not to have frequented public schools, and to have had good teachers at home, and to know that on such things a man should spend liberally.", "output3");
        test.run();
    }


    @Test
    public void test_3(){
        Test280 test = new Test280("Constantly observe who those are whose approbation thou wishest to have, and what ruling principles they possess. For then thou wilt neither blame those who offend involuntarily, nor wilt thou want their approbation, if thou lookest to the sources of their opinions and appetites.", "output4");
        test.run();
    }

    @Test
    public void test_file() throws IOException{
        File fichero_txt = new File("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\paragraph-line-by-line.txt");

        String[] array_txt = fichero_txt.readLinesIntoArray();

        Integer indice_linea = 1;
        for (String line : array_txt) {

            Test280 test = new Test280(line, "output", indice_linea);
            test.run(indice_linea);
            indice_linea++;


        }


    }

}

