
import java.util.Random;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * it returns a random item out of best n items and save it in a vector
 * @author ARPITA AYUSHI
 */
public class random {
    public void ran(int k, int l){
        v = new Vector();
        Random r = new Random();
        for(int i = 0 ; i<l;i++){
            int u = r.nextInt(k);
            v.add(u);
        }
        
    }
    public Vector v;
}
