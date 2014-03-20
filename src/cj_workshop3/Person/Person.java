/*
 * File name: Person.java
 * Author   : Le Hung Thien
 * ID       : SE61374
 * Class    : SE0865
 * Subject  : Core Java
 * Project  : Workshop 3 (cj_workshop3)
 * Date     : Mar 20 2014
 */
package cj_workshop3.Person;

import java.util.Scanner;

public class Person {

    private String code = "";       //  c
    private String name = "";   //  n
    private String addr = "";   // a
    private float mark = 0; //  m
    //  Constructors

    public Person() {
    }  //  WTH???

    public Person(String c, String n, String a, float m) {
        code = c;
        name = n;
        addr = a;
        mark = m;
    }
//  Getters and setters

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //  Input detail of the Person

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the person's code: ");
        code = sc.nextLine();
        System.out.println("Enter the person's name: ");
        name = sc.nextLine();
        System.out.println("Enter the person's address: ");
        addr = sc.nextLine();
        System.out.println("Enter the person's mark: ");
        mark = Float.parseFloat(sc.nextLine());
    }
    //  Output result implementation
    @Override
    public String toString()    {
        return code + ", " + name + ", " + addr + ", " + mark;
    }
}
