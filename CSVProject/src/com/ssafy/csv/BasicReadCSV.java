package com.ssafy.csv;

import java.io.*;
import java.util.Arrays;

public class BasicReadCSV {
	private static String path = "users.csv";
	private static String encoding = "utf-8"; 
    public static void main(String[] args) {
    	BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding));
            while ((line = br.readLine()) != null) {
                String[] field = line.split(cvsSplitBy);
                System.out.println(Arrays.toString(field));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    	
    	
    }
}
