package com.netvuvu.file;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class File {
    public String[] readLinesIntoArray(String filename){
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lineas = new ArrayList<String>();
        String linea = null;
        while((linea = bufferedReader.readLine())!=null){
            lineas.add(linea);
        }
        bufferedReader.close();
        return lineas.toArray(new String[lineas.size()]);
    }
}
