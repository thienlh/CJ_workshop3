/*
 * File name: Menu.java
 * Author   : Le Hung Thien
 * ID       : SE61374
 * Class    : SE0865
 * Subject  : Core Java
 * Project  : Workshop 3 (cj_workshop3)
 * Date     : Mar 20 2014
 */
package cj_workshop3;

import java.util.Scanner;

public class Menu {

    protected String[] hints;
    protected int n = 0;    //  current number of hints
    //  Constructer for creating menu with <size> elements
    Menu(int size) {
        if (size < 1) size = 10;
        hints = new String[size];
    }
    //  Adding a hints

    public void add(String newHints) {
        if (n < hints.length) {
            hints[n++] = newHints;
            
        }
    }
    //  Getting userChoice

    public int getChoice() {
        int userChoice = 0; //  User choice value
        if (n > 0) {
            //  Print menu
            for (int i = 0; i < n; i++) {
                System.out.println((i + 1) + ".\t" + hints[i]);
                System.out.print("Please choose an option: ");
                //  Get user choice
                Scanner sc = new Scanner(System.in);
                userChoice = Integer.parseInt(sc.nextLine());
            }
        }
        return userChoice;
    }
}
