
import java.io.IOException;
import java.util.Scanner;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *it gives choice to user to choose the method in q1 or q4
 * for q1, couple1 class is used whose method couple_formed is called and the result is stored in q5_couples_using_q1.xls.
 * later method gifting of class git is called which calculate the gifting performed.
 * Later method hap_comp of class Happiness is called, which prints the happiest couples.
 * for q4, break up is performed for least k happiest couples (using extract class instantiated by object e). couple1 class is used whose method couple_formed is called (param e is passed) and the result is stored in q5_couples_using_q4.xls.
 * later method gifting of class git is called which calculate the gifting performed.
 * Later method hap_comp of class Happiness is called, which prints the happiest couples.
 * @author ARPITA AYUSHI
 */
public class q5 {
    public static void main(String[] args) throws BiffException, IOException {
       while(true){
        System.out.println("To choose algorithm of q1, Type 1 or To choose algorithm of q4, Type 2");
        Scanner scanIn = new Scanner(System.in);
        int k = scanIn.nextInt();
        gift g = new gift();
        couple1 c1 = new couple1();
        if(k==1){
            c1.couple_formed();
            g.gifting("\\q5_couples_using_q1.xls");
            break;
        }
        else if(k==2){
            System.out.println("Enter the number of least happiest couples to form new couples");
            Scanner scanIn1 = new Scanner(System.in);
            int u = scanIn1.nextInt();
            c1.couple_formed();
            g.gifting("\\q5_couples_using_q1.xls");
            extract e = new extract();
            e.hap_comp(u);
            couple2 c2 = new couple2();
            c2.couple_formed(e);
            g.gifting("\\q5_couples_using_q4.xls");
            break;
        }
        else
            System.out.println("Invalid choice");
       }
       Happiness h = new Happiness();
       h.hap_comp();
    }
}
