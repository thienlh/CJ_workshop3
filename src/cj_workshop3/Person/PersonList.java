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

/**
 *
 * @author thienlh
 */
public class PersonList {
    //  Array of people
    private Person[] list = null;
    private int count=0;    //  Current index
    //  Constructor
    public PersonList(int size) {
        if (size<10) size=10;
        list = new Person[size];
    }
    //  Method for find person using their code
    public int find(String qCode)   {
        for (int i = 0; i < count; i++) {
            if (qCode.equals(list[i].getCode())) return i;
        }
        return -1;
    }
}
