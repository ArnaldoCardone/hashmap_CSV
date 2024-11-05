package com.acardone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Map<String, Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path:");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                if(map.get(name) == null){
                    map.put(name,votes);
                } else {
                    map.put(name, votes + map.get(name));
                }
                line = br.readLine();
            }

            for (String x : map.keySet()){
                System.out.println(x + " - " + map.get(x));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}