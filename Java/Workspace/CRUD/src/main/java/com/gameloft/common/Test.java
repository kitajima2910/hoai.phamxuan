/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.common;

import java.util.Locale;

/**
 *
 * @author Kitajima2910
 */
public class Test {

    public static void main(String[] args) {
        String[] countryCodes = java.util.Locale.getISOCountries();

        for (String countryCode : countryCodes) {
            Locale locale = new Locale("", countryCode);
            String code = locale.getCountry();
            String name = locale.getDisplayCountry();

            // use country code and country name...
//            System.out.println("code: " + code + " - name: " + name);
            System.out.println(countryCode);
        }
    }

}
