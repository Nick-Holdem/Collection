package Collection2;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Start {
    public static void main(String[] args) throws IOException, ParseException {
        //Read from file
        BufferedReader bufReader = new BufferedReader(new FileReader("Eemployee-input.txt"));
        ArrayList<String> InitialList = new ArrayList<>();

        String line = bufReader.readLine();
        while (line != null) {
            InitialList.add(line);
            line = bufReader.readLine();
        }
        System.out.println("\nOriginal ArrayList is : " + InitialList+"\n");
        System.out.println("-----------------FirstName------------------");
        //FirstName List------------------------------
        for (int i = 0; i < InitialList.size(); i++) {
            String firsName = InitialList.get(i).substring(0, InitialList.get(i).indexOf(" "));
            System.out.println(firsName);
        }
        //----------data in contains() -----------------
        ArrayList<String>ContainsList = new ArrayList<>();
        for (int j = 0; j < InitialList.size(); j++){
            String fullName = InitialList.get(j).substring(0, InitialList.get(j).lastIndexOf(" "));
            if (!ContainsList.contains(fullName))
            {
                ContainsList.add(fullName);
            }
        }
        //Write into file
        System.out.println("--------------------Age--------------------------");
        BufferedWriter bf = null;
        int age;
        try {
            // BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter("Eemployee-final.txt"));
             //dd.mm.yyyy
            for (int k = 0; k < InitialList.size(); k++){
                String dateOfBirth = InitialList.get(k).substring(InitialList.get(k).lastIndexOf(" ") +1, InitialList.get(k).length());
                Date dob = new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirth);

                long currentTime = System.currentTimeMillis();
                Calendar now = Calendar.getInstance();
                now.setTimeInMillis(currentTime);

                Calendar cal = Calendar.getInstance();
                cal.setTime(dob);
                age = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
                bf.write(InitialList.get(k) + " | " + age);
                bf.newLine();
                System.out.println(InitialList.get(k) + " | " + age);
            }
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
            bf.close();
        }
        //----OUT Terminal---
        System.out.println("\n----------This is distinct list-------------------- ");
        ContainsList.forEach(System.out::println);
        bufReader.close();
        System.out.println("\n-----------Before Sorting------------------\n"+ InitialList);
        Collections.sort(InitialList);
        System.out.println("\n----------------After Sorting-----------------\n"+ InitialList);
    }
}
