/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author Kitajima2910
 */
public class Overload1 {
 
    public native double func(double x);
//    public native double[] func(double[] x);
//    public native double[] func(float[] x);
//    public native double[] func(String x, String y);
    public native Overload1 func(Overload1 x);
    
}
