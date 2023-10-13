/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Kitajima2910
 */
public class TestOverloading {
    
    static {
        System.loadLibrary("libnative_cpp");
    }
    
    // Valid overloading of native method
    public native double func(double x);
    public native double func(double x, double y);
    public native double func(double x, String text);
    
    // Regular methods --> can still do a valid overload of native methods
    public double func(double x, double y, double z) {
        return x;
    }
    
    public static void main(String[] args) {
        TestOverloading overloading = new TestOverloading();
        System.out.println(overloading.func(1.1));
        System.out.println(overloading.func(2.2, 2.2));
        System.out.println(overloading.func(3.3, "Hoai"));
        System.out.println(overloading.func(4.4, 4.4, 4.4));
    }
}
