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
            System.out.println("=================== linea "+indice_fichero.toString()+"=====================");
            System.out.println("linea length " + line.length());
            Linea linea = new Linea(line);
            System.out.println(linea.substring(280,line));
            fichero_txt.writeToFile("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\output\\paragraph-line-by-line_"+indice_fichero.toString()+".txt", linea.substring(280,line));
            indice_fichero++;
            System.out.println("===================fin linea=====================");

        }


    }

    @Test
    public void test280(){
        String line = "1";
        File fichero_txt = new File("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\paragraph-line-by-line.txt");

        Linea linea = new Linea(line);

        fichero_txt.writeToFile("C:\\Users\\novac\\OneDrive\\Documentos\\100DaysOfCode\\marcus-aurelius-meditations\\output2\\paragraph-line-by-line_.txt", linea.substring(280,line));

    }
}

