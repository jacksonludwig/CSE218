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
    private int age = 10;
    
    public void show() {
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        return "age: " + age;
    }
}
