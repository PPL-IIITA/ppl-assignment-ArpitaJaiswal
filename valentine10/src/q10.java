
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * <h> Solution to q9</h>
 * <p> Calculate the happiness and compatibility using technique in q3<p>
 * <p>it uses a template (generic_template) to return random item out of best n items for girls, boys, and gifts.</p>
 * @author ARPITA AYUSHI
 */
public class q10 {
      public static void main(String[] args) throws IOException {
        // TODO code application logic here
        gifts v1 = new gifts();
        v1.gifting();
        valentine2 v = new valentine2();
       System.out.println("Enter the value of k");
        Scanner scanIn = new Scanner(System.in);
        int k = scanIn.nextInt();
         v.hap_comp(k);
        
    }
}
