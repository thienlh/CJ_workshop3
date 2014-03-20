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

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu(5);
        menu.add("Add new student.");
        menu.add("Remove a student.");
        menu.add("Update a student's detail");
        menu.add("List all students.");
        menu.add("Quit.");
        int userChoice = 0;
        PersonList list = new PersonList(50);
        do {
            System.out.println("\tSTUDENT MAGAGER");
            try {
                userChoice = menu.getChoice();
            } catch (Exception ex) {
                System.out.println("\n\tWRONG ITPUT\n* Option must be an integer number!");
                userChoice = 5;
            }
            switch (userChoice) {
                case 1:
                    try {
                        list.add();
                    } catch (Exception ex) {
                        System.out.println("\n\tWRONG INPUT\n* Mark must be float value!\n* Adding failed!");
                    }
                    break;
                case 2:
                    list.remove();
                    break;
                case 3:
                    try {
                        list.update();
                    } catch (Exception ex) {
                        System.out.println("\n\tWRONG INPUT\n* Mark must be float value!\n* Updating failed!");
                    }
                    break;
                case 4:
                    list.descSort();
                    list.print();
                    break;
            }
        } while (userChoice >= 1 && userChoice < 5);
        System.out.println("\nHAVE A NICE DAY. GOODBYE!");
    }
}
