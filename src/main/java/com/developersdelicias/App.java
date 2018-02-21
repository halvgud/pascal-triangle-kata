package com.developersdelicias;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static final int LOWER_LIMIT=3; 
    public static final int UPPER_LIMIT=14; 
    public static final int LOWER_LIMIT_FORMAT=3;
    public static final int UPPER_LIMIT_FORMAT=12;
    public static final int BIGGER_LIMIT_LINES=-2;
    public static final int NORMAL_LIMIT_LINES=-1;
    public static final int PADDING_LEFT_LAST_NUMBER=4;
    public static final int BIGGER_PADDING_LEFT_LAST_NUMBER=6;
    public final static String BIGGER_NODE="/   \\ ";
    public final static String NODE="/ \\ ";
    public static Boolean bigger = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nHow many lines?: ");
        int lines = sc.nextInt();

        int[][] matriz = new int[lines][];
        matriz[0] = new int[]{1};
        /*format stuff*/
        if (lines > LOWER_LIMIT && lines < UPPER_LIMIT) {
            lines = lines + lines - LOWER_LIMIT;
        } else if(lines>UPPER_LIMIT){
            lines = lines + lines + UPPER_LIMIT_FORMAT;
            bigger = true;
        }
        System.out.println(paddingBeLike("1", ++lines, false));
        for (int k = 1; k < matriz.length; k++) {
            matriz[k] = new int[k + 1];
            matriz[k][0] = matriz[k][k] = 1;
            lines = bigger?lines + BIGGER_LIMIT_LINES:lines+NORMAL_LIMIT_LINES;
            System.out.println(paddingBeLike(node(k), lines, false));
            System.out.print(paddingBeLike(("1"), --lines, false));
            for (int i = 1; i < k; i++) {
                matriz[k][i] = matriz[k - 1][i - 1] + matriz[k - 1][i];
                System.out.print(padLeft(matriz[k][i] + "", bigger?BIGGER_PADDING_LEFT_LAST_NUMBER:PADDING_LEFT_LAST_NUMBER));
            }
            System.out.println(padLeft("1",bigger?BIGGER_PADDING_LEFT_LAST_NUMBER:PADDING_LEFT_LAST_NUMBER));
        }
    }
    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

    public static String node(int branches) {
        String slashes = "";
        for (int i = 0; i < branches; i++) {
            slashes+=bigger?BIGGER_NODE:NODE;
        }
        return slashes;
    }

    public static String paddingBeLike(String txt, int qty, Boolean right) {
        String space = "";
        for (int i = 0; i < qty; i++) {
            space += " ";
        }
        return right ? (txt + space) : (space + txt);
    }        
}
