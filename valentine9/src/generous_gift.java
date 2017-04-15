
import java.util.Vector;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Inherits the gift class .
 * perform gifting by generous.
 * @author ARPITA AYUSHI
 */
public class generous_gift extends gift{
    public void gifting(Extract e,int j, int k){
        int budget = (int) e.b_main.elementAt(j);
        int b = budget, c=0;
        int min = 0, min_v = 0, m = 0, luxury = 0, vals = 0;
        Vector data = new Vector();
        while(budget>c){
                     min=1000;
        for(int l=1;l<e.gi_name.size();l++){
            int g_val = new Integer(Integer.parseInt(e.gi_co.toString())); 
            Integer val = new Integer(Integer.parseInt(e.gi_val.toString()));
                         if(min > g_val && !data.contains(g_val)){
                             min = g_val;
                             min_v = val;
                             m = l;
                           }
        }
        String s =   (String) e.gi_ty.elementAt(m);
                    if(s.equals("Luxury"))
                        luxury += min_v;
                    data.add(min);
                    budget -= min;
                    vals+=min_v;  
                }
                if(c==0)
                    budget+=min;
        gift_Cost= b-budget;
        Luxury_gift=luxury;
        Gift_Value=vals;
    }
    /*public void giftI(int c, int budget, Row row, Vector v){
        int b = budget;
        int m = 0;
        //v = new Vector();
                int miser_flag = 0;
                int min_v=0, vals = 0;
                int luxury = 0;
                int min=0;
                while(budget>c){
                     min=1000;
                    for(int l=1;l<sheet4.getRows();l++){
                      cell4 = sheet4.getCell(2, l);
                      int g_val = new Integer(Integer.parseInt(cell4.getContents().toString()));
                      cell4 = sheet4.getCell(3, l);
                      Integer val = new Integer(Integer.parseInt(cell4.getContents().toString()));
                         if(min > g_val && !data.contains(g_val)){
                             min = g_val;
                             min_v = val;
                             m = l;
                           }
                        }
                    cell4 = sheet4.getCell(1, m);
                    String s = cell4.getContents();
                    if(s.equals("Luxury"))
                        luxury += min_v;
                    data.add(min);
                    budget -= min;
                    vals+=min_v;  
                }
                if(c==0)
                    budget+=min;
                
                 cell = row.createCell(2);
                vt.add(b-budget);
                cell = row.createCell(3);
                vt.add(luxury);
                cell = row.createCell(7);
                vt.add(vals);
            }*/
}
