
import java.io.IOException;
import java.util.Scanner;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * <h> Solution to q9</h>
 * <p> Calculate the happiness and compatibility using technique in q3<p>
 * <p>it uses a template (generic_template) to choose the secondary criteria for top k alternatives for girls, boys, and gifts.</p>
 * @author ARPITA AYUSHI
 */
public class q9 {
      public static void main(String[] args) throws IOException, BiffException {
        // TODO code application logic here
        gifts v1 = new gifts();
        v1.gifting();
        valentine2 v = new valentine2();
        Extract e = new Extract();
        e.extract();
        Valentine1 v2 = new Valentine1();
       System.out.println("Enter the value of k");
        Scanner scanIn = new Scanner(System.in);
        int k = scanIn.nextInt();
                v2.open(k);

         v.hap_comp(k);
        
    }
}
