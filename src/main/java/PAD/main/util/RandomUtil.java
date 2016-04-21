/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main.util;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class RandomUtil {
    
    private static Random randomGenerator = new Random();
    
    public static int getRandomInt(int max) {
        return randomGenerator.nextInt(max);
    }
    
}
