/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Locale;

/**
 *
 * @author Asus
 */
public class Model {

    static Validate check = new Validate();

    public void menu() {

        Locale localeVi = new Locale("vi");
        Locale localeEn = new Locale("en");

        System.out.println("=======Login Program======");
        System.out.println("1. English");
        System.out.println("2. Vietnamese");
        System.out.println("3. Exit");
        System.out.println("please choice 1 option: ");
        int choice = check.getInt(localeEn, 1, 3);

        switch (choice) {
            case 1:
                runTPBank(localeEn);
                break;
            case 2:
                runTPBank(localeVi);
                break;
            case 3:
                return;
        }

    }

    public void runTPBank(Locale locale) {
        check.getAccount(locale);
        check.getPassword(locale);
        check.getCaptcha(locale);
    }
}
