package other;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestStudentMarks {
    public static void main(String[] args) {


            int studnum = 5;
            String[] Subject = {"Math", "Physics", "Chemistry"};

            Scanner scan = new Scanner(System.in);

                System.out.println("You have input: " + studnum);

                String[] StudentName = new String[studnum];

                for (int i = 0; i < studnum; i++) {
                    try {
                        System.out.println("Enter Student Name: ");
                        InputStreamReader isr = new InputStreamReader(System.in);
                        BufferedReader br = new BufferedReader(isr);

                        StudentName[i] = br.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(TestStudentMarks.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int[] sum = new int[5];
                int[] studavg = new int[5];
                int[][] studmarks = new int[studnum][5];

                    for (int i = 0; i < studnum; i++) {
                        for (int j = 0; j < 3; j++) {
                            System.out.println("Enter marks for " + StudentName[i] + " in " + Subject[j] + ": ");
                            new Scanner(System.in);
                            studmarks[i][j] = scan.nextInt();
                        }
                    }
                    scan.useDelimiter("\n");
                    for (int i = 0; i < studnum; i++) {
                        for (int j = 0; j < 3; j++) {
                            sum[i] += studmarks[i][j];
                        }
                        studavg[i] +=  (sum[i] / 3);
                    }
                    System.out.println("StudentName" + " " + "Math" + " " + "Physics" + " Chemistry " +" " + "Total"
                            + " " + "Average");
                    for (int i = 0; i < studnum; i++) {
                        System.out.print(StudentName[i] + "      ");
                        for (int j = 0; j < 3; j++) {
                            System.out.print(studmarks[i][j] + "      ");
                        }
                        System.out.print("   " + sum[i] + " ");
                        System.out.println(studavg[i]);
                    }
                    System.out.println("");

    }
}