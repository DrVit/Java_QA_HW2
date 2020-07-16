import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {

        int[][] arr = new int[3][3];
        arr[0][0] = 100;
        arr[0][1] = 200;
        arr[0][2] = 123;
        arr[1][0] = 300;
        arr[1][1] = 400;
        arr[1][2] = 500;
        arr[2][0] = 450;
        arr[2][1] = 700;
        arr[2][2] = 853;

        printArray(arr);

        saveArrayToFile(arr, "1.csv");

        int[][] nArr = loadArrayFromFile("1.csv");
        printArray(nArr);

    }
    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] loadArrayFromFile(String filename) {
        int[][] arr = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int rows = Integer.parseInt(br.readLine());
            int cols = Integer.parseInt(br.readLine());
            arr = new int[rows][cols];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = Integer.parseInt(br.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    private static void saveArrayToFile(int[][] arr, String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(String.valueOf(arr.length));
            bw.newLine();
            bw.write(String.valueOf(arr[0].length));
            bw.newLine();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    bw.write(String.valueOf(arr[i][j]));
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
             e.printStackTrace();
        }
    }

}
