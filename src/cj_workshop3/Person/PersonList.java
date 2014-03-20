/*
 * File name: PersonList.java
 * Author   : Le Hung Thien
 * ID       : SE61374
 * Class    : SE0865
 * Subject  : Core Java
 * Project  : Workshop 3 (cj_workshop3)
 * Date     : Mar 20 2014
 */
package cj_workshop3.Person;

import java.util.Scanner;

public class PersonList {
    //  Array of people

    private Person[] list = null;
    private int count = 0;    //  Current index
    //  Constructor

    public PersonList(int size) {
        if (size < 10) {
            size = 10;
        }
        list = new Person[size];
    }
    //  Method for find person using their code

    public int find(String qCode) {
        for (int i = 0; i < count; i++) {
            if (qCode.equals(list[i].getCode())) {
                return i;
            }
        }
        return -1;
    }
    //  Method for checking if the list is writeble (full) or not

    public boolean isWritable() {
        boolean result = true;
        if (count == list.length) {
            result = false;
        }
        return result;
    }
    //  Method for checking whether the list is empty or not

    public boolean isEmpty() {
        boolean result = false;
        if (count == 0) {
            result = true;
        }
        return result;
    }
    //  Method for adding person to list

    public void add() throws Exception {
        if (isWritable()) {
            String newCode; //  Code for finding
            String newName; //  New Name
            String newAddr; //  New Address
            float newMark;  //  New Mark
            //  Adding new person detail
            Scanner sc = new Scanner(System.in);
            int pos = 0;    //  Variable for checking whether newCode is existed or not.
            do {
                System.out.print("\n-----> Enter the student's code   : ");
                newCode = sc.nextLine().toUpperCase();
                pos = find(newCode);
                if (pos >= 0) {
                    System.out.println("\n\t[" + newCode + "] " + list[pos].getName() + " is existed!\n");
                }
            } while (pos >= 0);
            System.out.print("-----> Enter the student's name   : ");
            newName = sc.nextLine().toUpperCase();
            System.out.print("-----> Enter the student's address: ");
            newAddr = sc.nextLine().toUpperCase();
            System.out.print("-----> Enter the student's mark   : ");
            newMark = Float.parseFloat(sc.nextLine());
            list[count++] = new Person(newCode, newName, newAddr, newMark);
            System.out.println("\n\t" + list[count - 1].getName() + " has been added!\n");
        } else {
            System.out.println("\n                      THE LIST IS FULL!\n");
        }
    }
    //  Method for remove a known-code person

    public void remove() {
        if (isEmpty()) {
            System.out.println("\n                      THE LIST IS EMPTY!\n");
            return;
        }
        String removingCode;    //  Code for removing
        //  Enter a person's detail
        Scanner sc = new Scanner(System.in);
        System.out.print("\n-----> Enter the code of removing student: ");
        removingCode = sc.nextLine().toUpperCase();
        int pos = find(removingCode);
        if (pos < 0) {
            System.out.println("\n\tThis student does not exist!\n");
        } else {
            System.out.println("\n\tFOUND: " + list[pos].toString() + "\n");
            System.out.print("-----> Are you sure to DELETE this student? (y/N): ");
            if (sc.nextLine().substring(0, 1).equalsIgnoreCase("y")) {
                //  Shift up the remainder of the list
                for (int i = pos; i < count - 1; i++) {
                    list[i] = list[i + 1];
                }
                count--;
                System.out.println("\n\tThe student " + removingCode + " was removed!\n");
            }   else System.out.println("\n\t\tCANCELED!\n");
        }
    }
    //  Method for update person's detail

    public void update() throws Exception {
        if (isEmpty()) {
            System.out.println("\n                      THE LIST IS EMPTY!\n");
            return;
        }
        String updatingCode;    //  Code for updating
        //  Entering the person's code
        Scanner sc = new Scanner(System.in);
        System.out.print("\n-----> Enter the student's code for updating: ");
        updatingCode = sc.nextLine().toUpperCase();
        int pos = find(updatingCode);
        if (pos < 0) {
            System.out.println("\n\tThe student does not exist!\n");
        } else {
            System.out.println("\nFOUND: " + list[pos].toString() + "\n");
            //  Update name
            String newName;
            String newAddr;
            float newMark;
            System.out.print("-----> Enter [" + list[pos].getCode() + "]'s new name      : ");
            newName = sc.nextLine().toUpperCase();
            System.out.print("-----> Enter [" + list[pos].getCode() + "]'s new address   : ");
            newAddr = sc.nextLine().toUpperCase();
            System.out.print("-----> Enter [" + list[pos].getCode() + "]'s new mark      : ");
            newMark = Float.parseFloat(sc.nextLine());
            list[pos].setName(newName);
            list[pos].setAddr(newAddr);
            list[pos].setMark(newMark);
            System.out.println("\n\tThe student [" + list[pos].getName() + "] was updated!\n");
        }
    }
    //  Method for sorting list in descending order

    public void descSort() {
        if (isEmpty()) {
            //  System.out.println("The list is empty!");
            return;
        }
        //  Bubble sort base on person's mark
        for (int i = 0; i < count - 1; i++) {
            for (int j = count - 1; j > i; j--) {
                if (list[j].getMark() > list[j - 1].getMark()) {
                    //  Swap 2 people
                    Person temp;
                    temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
        }
    }
    //  Method for print the result

    public void print() {
        if (isEmpty()) {
            System.out.println("\n                      THE LIST IS EMPTY!\n");
            return;
        }
        System.out.println("\n\n-------------------------------------------------------------------");
        System.out.println("                       LIST OF STUDENTS");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("  ID  |         NAME        |            ADDRESS          |  MARK |");
        System.out.println("-------------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            //  System.out.println(list[i].toString());
            list[i].print();
        }
        System.out.println("\n\n");
    }
}
