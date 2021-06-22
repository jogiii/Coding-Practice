package corona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CandidateCode {



    public static boolean isPositive(String str1,String str2){

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int[] arr = new int[256];


        for(int i=0;i<c1.length;i++){
            int index = (int)c1[i];

            arr[index]=1;
        }

        for(int i=0;i<c2.length;i++){
            int index = (int)c2[i];
            arr[index]--;

        }

        for(int i: arr){

            if(i<0)
                return false;



        }

        return true;
    }
//very nice
    private static boolean isSubSequenceFound(String str1, String str2){
        int j = 0;
        for(int i = 0; i < str2.length(); i++){
            // If char found move to next char
            if(str1.charAt(j) == str2.charAt(i)){
                ++j;
            }
            // Equal means all the characters of str1 are
            // found in str2 in order
            if(j == str1.length()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String virus = sc.nextLine();

        int noOfPeoples = sc.nextInt();
        String list[]=new String[noOfPeoples];
        sc.nextLine();
        for (int i = 0; i < list.length; i++)
        {
            list[i] = sc.nextLine();
        }


        for(String str: list)
        {
             if(isSubSequenceFound(str,virus)){
                 System.out.println("POSITIVE");
             }
             else
                 System.out.println("NEGATIVE");
        }



}}
