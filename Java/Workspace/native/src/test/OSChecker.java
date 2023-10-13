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
public class OSChecker {
    
    private static final String OS = System.getProperty("os.name").toLowerCase();
    
    public static void main(String[] args) {
        System.out.println(OS);
        System.out.println(isWin());
    }
 
    private static boolean isWin() {
        return OS.contains("win");
    }
    
}
