/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal;

import java.util.Scanner;

/**
 *
 * @author Edwin Garcia
 */
public class Pascal {

    /**
     * @param args the command line arguments
     */
   public static Boolean bigger = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nHow many lines?: ");
        int lines = sc.nextInt();

        int[][] matriz = new int[lines][];
        matriz[0] = new int[]{1};
        /*format stuff*/
        if (lines > 3 && lines < 14) {
            lines = lines + lines - 3;
        } else if(lines>13){
            lines = lines + lines + 12;
            bigger = true;
        }
        System.out.println(paddingBeLike("1", ++lines, false));
        for (int k = 1; k < matriz.length; k++) {
            matriz[k] = new int[k + 1];
            matriz[k][0] = matriz[k][k] = 1;
            lines = bigger?lines - 2:lines-1;
            System.out.println(paddingBeLike(node(k), lines, false));
            System.out.print(paddingBeLike(("1"), --lines, false));
            for (int i = 1; i < k; i++) {
                matriz[k][i] = matriz[k - 1][i - 1] + matriz[k - 1][i];
                System.out.print(padLeft(matriz[k][i] + "", bigger?6:4));
            }
            System.out.println(padLeft("1",bigger?6:4));
        }
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

    public static String node(int ramas) {
        String slashes = "";
        for (int i = 0; i < ramas; i++) {
            slashes+=bigger?"/   \\ ":"/ \\ ";
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

