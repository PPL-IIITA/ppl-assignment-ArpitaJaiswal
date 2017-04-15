
import java.io.IOException;
import java.util.Scanner;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * It gives user the choice to implement one of the three methods.
 * Random class is used to generate a list of boys using random_boys method.
 * One of the three class object is instantiated according to what user chooses and girlfriend of boys get printed if any.
 * for getting the required output abstract class anonymous_method is used which has method couple inherited by various implementations.
 * Upcasting to base class i.e. class anonymous_method is used where method couple() of childen classes is upcasted. 
 * @author ARPITA AYUSHI
 */
public class q7 {
    public static void main(String[] args) throws BiffException, IOException {
        random r = new random();
        r.random_boys();
        anonymous_method am;
        System.out.println("Type 1 to implement sorted array, Type 2 to implement hash table, Type 3 to implement linked list/array, else default option runs");
        Scanner scanIn = new Scanner(System.in);
        int k = scanIn.nextInt();
        if(k==1){
            am = new sorted_array();
            am.couple(r);
        }
        else if(k==2){
            am = new hash_table();
            am.couple(r);
        }
        else if(k==3){
            am = new linked_list();
            am.couple(r);
        }
        else{
            am = new linked_list();
            am.couple(r);
        }
    }
}
