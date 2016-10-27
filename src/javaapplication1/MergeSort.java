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
public class MergeSort {
    
     public static int[] mergeSort(int [] list) {
        if (list.length <= 1) {
            return list;
        }
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        mergeSort(first);
        mergeSort(second);
        merge(first, second, list);
        return list;
    }
    
    private static void merge(int[] first, int[] second, int [] result) {
        int iFirst = 0;  
        int iSecond = 0;
        int j = 0;
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
                } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
    
    public static void main(String a[]) {
        String fileName = "E:\\List of Numbers\\reverse_list.txt";
        //String fileName = "E:\\List of Numbers\\random_list.txt";
        //String fileName = "E:\\List of Numbers\\sorted_list.txt";
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
        mergeSort(numbers);
        long time = System.currentTimeMillis() - start;
        System.out.println(time);
    }
}
