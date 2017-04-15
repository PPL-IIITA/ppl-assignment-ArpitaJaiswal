
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * <h> Solution to q3</h>
 * <p> Calculate the happiness and compatibility<p>
 * @author ARPITA AYUSHI
 */
public class q3 {
      public static void main(String[] args) throws IOException {
        // TODO code application logic here
        gift v1 = new gift();
        v1.gifting();
        valentine2 v = new valentine2();
       System.out.println("Enter the value of k, to see k most happiest couple and k most compatible couples");
        Scanner scanIn = new Scanner(System.in);
        int k = scanIn.nextInt();
         v.hap_comp(k);
        
    }
}
