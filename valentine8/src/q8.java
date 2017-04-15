
import java.io.IOException;
import java.util.Scanner;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * it gives choice to user to choose one of the gifting technique.
 * One of the two class object is instantiated according to what user chooses.
 * for getting the required output abstract class GiftSelector is used which has method gifting inherited by various implementations.
 * Upcasting to base class i.e. class GiftSelector is used where method gifting() of childen classes is upcasted. 
 * @author ARPITA AYUSHI
 */
public class q8 {
    public static void main(String[] args) throws BiffException, IOException {
        GiftSelector gs;
        System.out.println("Type 1 to implement normal gifting, Type 2 to implement gifting 0f each type, else default option runs");
        Scanner scanIn = new Scanner(System.in);
        int k = scanIn.nextInt();
        if(k==1){
            gs = new gift();
            gs.gifting();
        }
        else if(k==2){
            gs = new gift_one();
            gs.gifting();
        }
        else{
            gs = new gift();
            gs.gifting();
        }
    }
}
