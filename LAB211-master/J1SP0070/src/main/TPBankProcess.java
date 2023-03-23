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
import java.util.Random;
import java.util.ResourceBundle;

public class TPBankProcess {

    public void getWordLanguage(Locale locale, String key) {
        ResourceBundle labels = ResourceBundle.getBundle("messages", locale);
        System.out.println(labels.getString(key));
    }

    public int randomRange(int min, int max) {
        Random rd = new Random();
        return rd.nextInt(max - min + 1) + min;
    }

    public String generateCaptcha() {

        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String alphaNumeric = alpha + alpha.toUpperCase() + digits;

        String res = "";
        for (int i = 0; i < 5; i++) {
            res += alphaNumeric.charAt(randomRange(0, alphaNumeric.length() - 1));
        }

        return res;
    }
}
