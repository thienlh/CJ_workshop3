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

/**
 *
 * @author thienlh
 */
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

    public void add() {
        if (isWritable()) {
            String newCode;
            String newName;
            String newAddr;
            float newMark;
            //  Adding new person detail
            Scanner sc = new Scanner(System.in);
            int pos = 0;    //  Variable for checking whether newCode is existed or not.
            do {
                System.out.print("Enter the person's code: ");
                newCode = sc.nextLine().toUpperCase();
                pos = find(newCode);
                if (pos >= 0) {
                    System.out.println("This person is existed!");
                }
            } while (pos >= 0);
            System.out.print("Enter the person's name   : ");
            newName = sc.nextLine().toUpperCase();
            System.out.print("Enter the person's address: ");
            newAddr = sc.nextLine().toUpperCase();
            System.out.print("Enter the person's mark   : ");
            newMark = Float.parseFloat(sc.nextLine());
            list[count++] = new Person(newCode, newName, newAddr, newMark);
            System.out.println("New person has been added!");
        } else {
            System.out.println("The list is full!");
        }
    }
    //  Method for remove a known-code person

    public void remove() {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        String removingCode;    //  Code for removing
        //  Enter a person's detail
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the code of removing person: ");
        removingCode = sc.nextLine().toUpperCase();
        int pos = find(removingCode);
        if (pos < 0) {
            System.out.println("This person does not exist!");
        } else {
            System.out.println("Found: " + list[pos].toString());
            //  Shift up the remainder of the list
            for (int i = 0; i < count - 1; i++) {
                list[i] = list[i + 1];
            }
            count--;
            System.out.println("The person " + list[pos].getName() + "(" + removingCode + ") was removed!");
        }
    }
    //  Method for update person's detail

    public void update() {
        if (isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        String updatingCode;    //  Code for updating
        //  Entering the person's code
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the person's code for updating: ");
        updatingCode = sc.nextLine().toUpperCase();
        int pos = find(updatingCode);
        if (pos < 0) {
            System.out.println("The person does not exist!");
        } else {
            System.out.println("Found: " + list[pos].toString());
            //  Update name
            String newName;
            String newAddr;
            float newMark;
            System.out.print("Enter the person's new name   : ");
            newName = sc.nextLine();
            System.out.print("Enter the person's new address: ");
            newAddr = sc.nextLine();
            System.out.print("Enter the person's new mark   : ");
            newMark = Float.parseFloat(sc.nextLine());
            list[pos].setName(newName);
            list[pos].setAddr(newAddr);
            list[pos].setMark(newMark);
            System.out.println("The person " + list[pos].getName() + "(" + updatingCode + ") was updated!");
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
                if (list[j].getMark() > list[j-1].getMark()) {
                //  Swap 2 people
                    Person temp;
                    temp = list[j];
                    list[j] = list[j-1];
                    list[i-1] = temp;
                }
            }
        }
    }
    //  Method for print the result
    public void print() {
        if (isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        System.out.println("\tLIST OF PEOPLE");
        for (int i = 0; i < count; i++) {
            System.out.println(list[i].toString());
        }
    }
}
