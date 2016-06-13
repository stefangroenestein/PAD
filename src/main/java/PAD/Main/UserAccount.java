/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.Main;

/**
 * A user account on the game, loaded trough the database or newly created
 *
 * @author Youri Dudock
 */
public class UserAccount {

    private String name; // name of the user

    private HappinessMeter happinessMeter = new HappinessMeter(); // the happiness for this user

    /**
     *
     * @param name name of the user
     */
    public UserAccount(String name) {
        this.name = name;
    }

    /**
     *
     * @return the happiness meter
     */
    public HappinessMeter getMeter() {
        return happinessMeter;
    }

    /**
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

}
