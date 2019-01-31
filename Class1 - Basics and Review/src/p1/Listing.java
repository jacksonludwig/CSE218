/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

/**
 *
 * @author Jackson
 */
public class Listing {
    private int age;
    
    public Listing() {
        age = 10;
    }
    
    public Listing(int age) {
        this.age = age;
    }
    
    public void show() {
        System.out.println(this);
    }
    
    public Listing clone() {
        return new Listing(age); // age is that of the object who invoked the clone method
    }
    
    @Override
    public String toString() {
        return "age: " + age;
    }
}
