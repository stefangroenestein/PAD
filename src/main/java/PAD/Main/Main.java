/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.Main;

import PAD.interfaceKit.KitController;

/**
 *
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class Main {

    static boolean magneet = true;
    private static KitController controller = new KitController();

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        controller.start();
    }
}