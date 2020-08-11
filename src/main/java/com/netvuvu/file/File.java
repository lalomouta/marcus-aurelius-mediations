package com.netvuvu.file;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File {

    FileReader fichero;

    public File(String filename) {
        try {
            this.fichero = new FileReader(filename);
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public String[] readLinesIntoArray() throws IOException {
        //FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fichero);
        List<String> lineas = new ArrayList<String>();
        String linea = null;
        while((linea = bufferedReader.readLine())!=null){
            lineas.add(linea);
        }
        if (lineas == null) lineas.add("empty");
        bufferedReader.close();

        return lineas.toArray(new String[lineas.size()]);
    }

    public void writeToFile(String path, String texto){
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(texto);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
