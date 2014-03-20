/*
 * File name: Main.java
 * Author   : Le Hung Thien
 * ID       : SE61374
 * Class    : SE0865
 * Subject  : Core Java
 * Project  : Workshop 3 (cj_workshop3)
 * Date     : Mar 20 2014
 */
package cj_workshop3;

import cj_workshop3.Person.PersonList;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String contine = "y"; //  Prompt user for continue or quit program
        do {
            Menu menu = new Menu(5);
            menu.add("Add new student.                                  *");
            menu.add("Remove a student.                                 *");
            menu.add("Update a student's detail.                        *");
            menu.add("List all students.                                *");
            menu.add("Quit.                                             *");
            int userChoice = 0;
            PersonList list = new PersonList(50);
            do {
                System.out.println("*******************************************************************");
                System.out.println("*                       STUDENT MAGAGER                           *");
                System.out.println("*******************************************************************");
                try {
                    userChoice = menu.getChoice();
                } catch (Exception ex) {
                    System.out.println("---------------------------WRONG INPUT-----------------------------\n\t+ Option must be an integer number!");
                    userChoice = 5;
                }
                switch (userChoice) {
                    case 1:
                        try {
                            list.add();
                        } catch (Exception ex) {
                            System.out.println("---------------------------WRONG INPUT-----------------------------\n\t+ Mark must be float value!\n\t+ Adding failed!");
                        }
                        break;
                    case 2:
                        list.remove();
                        break;
                    case 3:
                        try {
                            list.update();
                        } catch (Exception ex) {
                            System.out.println("---------------------------WRONG INPUT-----------------------------\n\t+ Mark must be float value!\n\t+ Updating failed!");
                        }
                        break;
                    case 4:
                        list.descSort();
                        list.print();
                        break;
                }
            } while (userChoice >= 1 && userChoice < 5);
            System.out.print("-----> Do you want to QUIT? (Y/n): ");
            Scanner sc = new Scanner(System.in);
            contine = sc.nextLine();
        } while (contine.substring(0, 1).equalsIgnoreCase("n"));
        System.out.println("--------------------HAVE A NICE DAY. GOODBYE!----------------------");
    }
}
