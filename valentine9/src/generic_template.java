
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * it is a template to choose the secondary criteria for top k alternatives for girls, boys, and gifts.
 * 
 * @author ARPITA AYUSHI
 */
public class generic_template <T>{
    /**
     * it sort according to the secondary criteria
     * @param t is an array of template type
     * @param v is a vector that stores the result. 
     * @param e is the object of class extract which has the information about the top k values.
     */
    public void sort(T[] t, Vector v , Extract e){
        for(int i = 0; i<v.size(); i++){
            for(int j=0;j<v.size();j++){
                if(new Integer(Integer.parseInt(v.elementAt(j).toString())) > new Integer(Integer.parseInt(v.elementAt(j+1).toString()))){
                    int temp = new Integer(Integer.parseInt(v.elementAt(j).toString()));
                    v.setElementAt(new Integer(Integer.parseInt(v.elementAt(j).toString())), j);
                    v.setElementAt(temp, j+1);
                    temp = new Integer(Integer.parseInt(e.b_name.elementAt(j).toString()));
                    e.b_name.setElementAt(new Integer(Integer.parseInt(e.b_name.elementAt(j).toString())), j);
                    e.b_name.setElementAt(temp, j+1);
                }
            }
        }
         for(int i = 0; i<t.length; i++){
             t[i] = (T) e.b_name.elementAt(i);
         }
    }
}
