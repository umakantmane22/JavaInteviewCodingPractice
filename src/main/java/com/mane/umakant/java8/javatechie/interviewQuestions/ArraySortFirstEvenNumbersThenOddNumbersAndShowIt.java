package com.mane.umakant.java8.javatechie.interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySortFirstEvenNumbersThenOddNumbersAndShowIt {
    public static void main(String a[]){
       // Q31:  from given array sort first even numbers and then odd numbers and show it;
        //int[] arrEvenOddOrderInput = { 1, 2, 5, 4, 7, 8, 11, 20 };
        // op: 2 4 8 20 1 5 7 11
        int[] arrEvenOddOrderInput = { 1, 2, 5, 4, 7, 8, 11, 20 };
        // using Java7
        int outPutArray[]=new int[arrEvenOddOrderInput.length];
        int index=0;
        // add all even numbers to resultant array
        for (int i=0;i<arrEvenOddOrderInput.length;i++){
            if(arrEvenOddOrderInput[i]%2==0){
                outPutArray[index]=arrEvenOddOrderInput[i];
                index++;
            }
        }
        // add all odd numbers to resultant array
        for (int i=0;i<arrEvenOddOrderInput.length;i++){
            if(arrEvenOddOrderInput[i]%2!=0){
                outPutArray[index]=arrEvenOddOrderInput[i];
                index++;
            }

        }
        for (int i=0;i<outPutArray.length;i++){
            System.out.print(outPutArray[i]+" ");
        }

        // using Java8

        List<Integer> evenOddSort=new ArrayList<>();
        List<Integer>evenNos=Arrays.stream(arrEvenOddOrderInput)
                .boxed()
                .filter(i->i%2==0)
                .collect(Collectors.toList());
        List<Integer>oddNos=Arrays.stream(arrEvenOddOrderInput)
                .boxed()
                .filter(i->i%2!=0)
                .collect(Collectors.toList());
        evenOddSort.addAll(evenNos);
        evenOddSort.addAll(oddNos);
        System.out.println("");
        System.out.println(evenOddSort);

    }
}
