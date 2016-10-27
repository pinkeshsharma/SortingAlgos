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
public class QuickSort {
    
    public static int[] quicksort(int [] list) {
        quicksort(list, 0, list.length-1);
        return list;
    }
    
    private static void quicksort(int list[], int from, int to) {
        if (from >= to) {
            return;
        } 
        int pivot = list[from];
        int i = from - 1;
        int j = to + 1;
        while (i < j) {
            i++;
            while (list[i] < pivot) { i++; }
            j--;
            while (list[j] > pivot) { j--; }
            if (i < j) {
                swap(list, i, j);
            }
        }
        quicksort(list, from, j);
        quicksort(list, j + 1, to);
    }
    
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
      
    public static void main(String a[]) {
        
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
                fileName + "'" + ex);                
        }
        long start = System.currentTimeMillis();
        int[] sortedArr = quicksort(numbers);
        long time = System.currentTimeMillis() - start;
        System.out.println(time);
    }
}
