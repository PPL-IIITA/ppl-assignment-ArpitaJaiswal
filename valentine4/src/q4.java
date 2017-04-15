
import java.io.IOException;
import java.util.Scanner;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Solution to q4.
 * it instantiate the object of extract class and calls off the method hap_comp passing param k (least happiest couple).
 * it passes the object of class extract 'e' as parameter to the method newcouple of class couple.
 * @author ARPITA AYUSHI
 */
public class q4 {
        public static void main(String[] args) throws BiffException, IOException {
            extract e = new extract();
            System.out.println("Enter the value of k, to see k least happiest couple");
            Scanner scanIn = new Scanner(System.in);
            int k = scanIn.nextInt();
            e.hap_comp(k);   
            couple c = new couple();
            c.newcouple(e);
        }

}
