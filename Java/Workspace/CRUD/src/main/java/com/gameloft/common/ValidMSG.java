/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.common;

/**
 *
 * @author Kitajima2910
 */
public class ValidMSG {

    public ValidMSG() {
        
    }
    
    public static boolean isEmpty(String str) {
        return str.length() == 0;
    }
    
    public static boolean isEmail(String str) {
        return str.matches("^.{1,}@\\w{2,}(.\\w{2,}){1,2}$");
    }
    
    public static boolean isMin(String str, int num) {
        return str.length() <= num;
    }
    
    public static void main(String[] args) {
        if(ValidMSG.isEmail("kitajima2910@gmail.com")) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }
    
}
