/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1.test11;

import test1.Test1;

/**
 *
 * @author Kitajima2910
 */
public class Test2 {
    
    public native double times(double a, double b);
    
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        
        double result1 = test1.multiple(1.1, 2.2);
        System.out.println(result1);
        
        double result2 = test2.times(1.1, 2.2);
        System.out.println(result2);
    }
    
}
