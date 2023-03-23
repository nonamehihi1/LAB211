/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Asus
 */
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

//viet thuong la ngon ngu, viet hoa la country

public class Validate {

    static TPBankProcess tpp = new TPBankProcess();

    public String getString(Locale locale) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String result = in.nextLine();
            if (result.trim().isEmpty()) {
                tpp.getWordLanguage(locale, "checkEmptyString");
            } else {
                return result;
            }
        }
    }

    public int getInt(Locale locale, int min, int max) {
        int number = 0;

        while (true) {

            try {
                number = Integer.parseInt(getString(locale));
                if (number >= min && number <= max) {
                    break;
                } else {
                    tpp.getWordLanguage(locale, "checkNumberRange");
                }

            } catch (NumberFormatException e) {
                tpp.getWordLanguage(locale, "checkEnterInputAgain");
            }
        }

        return number;
    }

    public String getAccount(Locale locale) {
        String account = "";

        while (true) {
            tpp.getWordLanguage(locale, "enterAccount");
            account = getString(locale);
            if (account.matches("\\d{10}")) {
                break;
            } else {
                tpp.getWordLanguage(locale, "errorAccount");
            }
        }
        return account;
    }

    
    public String getPassword(Locale locale){
        String password = "";
        while (true) {            
            tpp.getWordLanguage(locale, "enterPassword");
            password = getString(locale);
            Pattern p = Pattern.compile("^[0-9a-zA-Z]{8,31}$");
            Pattern pDigit = Pattern.compile("[0-9]+");
            Pattern pAnpha = Pattern.compile("[a-zA-Z]+");
            if(p.matcher(password).find() && pAnpha.matcher(password).find() && pDigit.matcher(password).find()){
                break;
            }else{
                tpp.getWordLanguage(locale, "errorPassword");
            }
        }
        return password;
    }

    public String getCaptcha(Locale locale) {
        String captchaInput = "";
        String captchaGenerated = "";

        while (true) {
            captchaGenerated = tpp.generateCaptcha();
            System.out.println(captchaGenerated);

            tpp.getWordLanguage(locale, "enterCaptcha");
            captchaInput = getString(locale);

            if (captchaGenerated.contains(captchaInput)) {
                tpp.getWordLanguage(locale, "loginSuccess");
                break;
            } else {
                tpp.getWordLanguage(locale, "errorCaptcha");
            }
        }

        return captchaInput;
    }

}
