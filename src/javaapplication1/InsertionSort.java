/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Pinkesh
 */
public class InsertionSort {

    public static int[] insertionSortAsc(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i;
            while (j > 0 && numbers[j - 1] > key) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = key;
        }
        return numbers;
    }

    public static int[] insertionSortDesc(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] < key) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
                numbers[j + 1] = key;
            }
        }
        return numbers;
    }

    public static void main(String args[]) {
       
        //String fileName = "E:\\List of Numbers\\reverse_list.txt";
        //String fileName = "E:\\List of Numbers\\random_list.txt";
        String fileName = "E:\\List of Numbers\\sorted_list.txt";
        String line;
        int []numbers = new int[1000];
        
        
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int i = 0;
            while((line = bufferedReader.readLine()) != null) {
                numbers[i] = Integer.parseInt(line.trim());
                i += 1;
            }   
            bufferedReader.close();         
        }
        catch(Exception ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        long start = System.currentTimeMillis();
        insertionSortAsc(numbers);
        long time = System.currentTimeMillis() - start;
        System.out.println(time);
    }

}
