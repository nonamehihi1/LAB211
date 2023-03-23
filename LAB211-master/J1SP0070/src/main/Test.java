/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Test {
        public static int randomRange(int min, int max) {
        Random rd = new Random();
        return rd.nextInt(max - min +1);// phạm vi giá trị được chuyền vào, ví dụ: rd.NextInt(100) + 1 = [1,100]
    }
        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
            System.out.println(randomRange(10, 15));
        }
        
        static     boolean isPassword(String pass) {
        int passLength = pass.length();
        boolean isPass = true;

        if (passLength >= 8 && passLength <= 31) {
//            for (int i = 0; i < passLength; i++) {
//                if (pass.matches("\\D+") && pass.matches("\\W+")   ) {
//                    isPass = false;
//                    break;
//                }
//            }
            if (pass.matches("\\D+") && pass.matches("\\W+")   )
                isPass = false;
            if (pass.matches("\\d+") || pass.matches("[a-zA-Z]+")) {
                isPass = false;
            }
        } else {
            isPass = false;
        }
        return isPass;
    }
}
