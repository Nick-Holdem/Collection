package Colection;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
//-----------Read file.txt-------
        HashMap<String, String> listOfProduct = new HashMap<>();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get("employee-input.txt").toFile()));
        System.out.println("-----------Initial HashMap-----------");
        while ((line = reader.readLine()) != null)
        {
         String[] parts = line.split("[|]");
            if (parts.length >= 2)
            {
                String key = parts[0];
                String value = parts[1];
                listOfProduct.put(key, value);
                System.out.println( key + " | " + listOfProduct.get(key));
            }
        }//--------------add=> list0fProduct.pat(key,value)------------------
        listOfProduct.put(String.valueOf(6), "Fructe");
        listOfProduct.put(String.valueOf(7), "Carne");
        listOfProduct.put(String.valueOf(8), "Biscuiți");
        listOfProduct.put(String.valueOf(9), "Ceai");
//-----Out Terminal---add + Update----
        reader.close();
        System.out.println("------------Add line------------");
        listOfProduct.keySet().forEach(key -> System.out.println(key + " | " + listOfProduct.get(key)));
        listOfProduct.put(String.valueOf(7), "Zahăr");
        System.out.println("------------Update----------------");
        listOfProduct.keySet().forEach(key -> System.out.println(key + " | " + listOfProduct.get(key)));
        BufferedWriter bf = null;
//-------Write file output.txt-----
        try {
         // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter("employee-output.txt"));
            for (Map.Entry<String, String> entry : listOfProduct.entrySet()) {
                bf.write(entry.getKey() + " | " + entry.getValue());// put key and value separated by a colon
                bf.newLine();// new line
            }
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
            bf.close();
        }
    }
}
