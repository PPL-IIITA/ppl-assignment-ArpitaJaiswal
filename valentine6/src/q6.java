
import java.io.IOException;
import java.util.Scanner;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Solution to q6.
 * it run loop for k times to form new coupe for least k happiest couple.
 * it calls newcouple method of class couple and pass param e (object of extract class) and i (iteration constant, for condition of least happiest couple should not be performed for 1st time ).
 * gifting is performed for each iteration to calculate the k least happiest couples.
 * Then happiness is calculated using hap_comp method of extract class.
 * @author ARPITA AYUSHI
 */
public class q6 {
        public static void main(String[] args) throws BiffException, IOException {
            extract e = new extract();
            System.out.println("Enter the value of k, 0<k<50 ,to see k least happiest couple");
            Scanner scanIn = new Scanner(System.in);
            int k = scanIn.nextInt();
            int i;
            couple c = new couple();
            gift g = new gift();
            for(i=0;i<k;i++){
                c.newcouple(e,i);
                g.gifting();
                e.hap_comp(k);
            }
        }

}
