
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * It is an abstract class
 * It is a base class implemented by various child classes.
 * It uses inheritance.
 * @author ARPITA AYUSHI
 */
public abstract class GiftSelector {
    /**
     * to perform gifting according to the choice of user.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    abstract public void gifting()throws FileNotFoundException, IOException;
}
