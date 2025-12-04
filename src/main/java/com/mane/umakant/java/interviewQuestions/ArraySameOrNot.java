package com.mane.umakant.java.interviewQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySameOrNot {
    public static void main(String a[]){
        //Q30:  compare two different array is same or not. Order of element is no matter
        int[] arrAccenture1 = { 3, 2, 5, 7 };
        int[] arrAccenture2 = { 2, 3, 7, 5 };
        boolean arraySameFlag=true;
        int n1=arrAccenture1.length;
        int m1=arrAccenture2.length;
        if (n1!=m1){
            arraySameFlag=false;
        }else {
            Arrays.sort(arrAccenture1);
            Arrays.sort(arrAccenture2);
            if(!Arrays.equals(arrAccenture1,arrAccenture2)){
                arraySameFlag=false;
            }
            //or
            for (int i=0;i<m1;i++){
                if (arrAccenture1[i] != arrAccenture2[i]) {
                    arraySameFlag=false;
                    break;
                }
            }
        }
        if (arraySameFlag){
            System.out.println("Q30: array same");
        }else {
            System.out.println("Q30: array not same");
        }
        //or
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int n :arrAccenture1) set1.add(n);
        for(int n:arrAccenture2) set2.add(n);
        System.out.println("Arrays contain same unique elements? " + set1.equals(set2));
    }
}
