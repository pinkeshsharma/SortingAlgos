/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * @author Pinkesh
 */
public class JavaApplication1 {


    public static int numberNeeded(String first, String second) {
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        int count = 0;
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        loop1:
        for (int i=0;i<firstArray.length;i++) {
            char c = firstArray[i];
            for(int j=0;j<secondArray.length;j++){
                char d = secondArray[j];
                if(c == d){
                    firstArray[i] = '1';
                    secondArray[j] = '1';
                    continue loop1;
                } else if (c < d){
                    continue loop1;
                }
            }
        }
        
        for(char c : firstArray){
            if(c != '1'){
                count += 1;
            }
        }
        for(char c : secondArray){
            if(c != '1'){
                count += 1;
            }
        }
       
        return count;
    }
  
   public static void main(String[] args) throws IOException {
     Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    //String s = "Pinkesh, Sharma";
    String[] str = s.split(",\\s");
    System.out.println(str[0]);
    System.out.println(str[1]);
    
    char[] firstArray = str[0].toCharArray();
    char[] secondArray = str[1] != null ? str[1].toCharArray() : new char[0];
    int i = firstArray.length - 1, j = secondArray.length - 1, index = 0;
    char[] resultArray = new char[i > j ? j : i];
    while(true){
        if(i > 0 && j > 0 && firstArray[i] == secondArray[j]){
            resultArray[index] = firstArray[i];
            index += 1;
            i -=1; j -= 1;
        }   else {
            break;
        }
    }
    
    if(resultArray[0] != 0){
        for(int k = resultArray.length -1; k>=0; k--){
            if(resultArray[k] != 0) {
                System.out.print(resultArray[k]);
            }
        }
    } else {
        System.out.print("Null");
    }
  }
}
    

