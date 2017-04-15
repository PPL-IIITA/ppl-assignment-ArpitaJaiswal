
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * it is linked list implementation to find girlfriends.
 * it inherits the class anonymous_method.
 * Implement all variants via inheritance and use upcasting to the base class
 * @author ARPITA AYUSHI
 */
public class linked_list extends anonymous_method{
    /**
     * for linked list implementation
     */
    public void linked(){
        
        JFileChooser jChooser = new JFileChooser();
        String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
        try {
            workbook2 = jxl.Workbook.getWorkbook(new File(doc + "\\couples.xls"));
        } catch (IOException ex) {
            Logger.getLogger(linked_list.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(linked_list.class.getName()).log(Level.SEVERE, null, ex);
        }
        jxl.Sheet sheet1 = workbook2.getSheet(0);
        jxl.Cell cell;
        arr = new String[sheet1.getRows()-1][2];
        int i;
        for(i=1;i<sheet1.getRows();i++){
            cell = sheet1.getCell(1, i);
            arr[i-1][0] = cell.getContents();
            cell = sheet1.getCell(0, i);
            arr[i-1][1] = cell.getContents();
        }
        
    }
    /**
     * to store the information of girlfriends of various boys.
     * @param r is object of class random which contain the list of boys.
     */
    @Override
    public void couple(random r) {
        linked();
        int found = 0;
        for(int i=0;i<r.boys.size();i++){
            found = 0;
            System.out.print("boy = "+r.boys.elementAt(i)+"  ");
            for(int j =0;j<arr.length;j++){
                if(arr[j][0].equals(r.boys.elementAt(i))){
                    System.out.println("girl = "+arr[j][1]);
                    found = 1;
                    break;
                }
            }
            if(found==0){
                System.out.println("girl = NOT COUPLE");
            }
        }
    }
     private jxl.Workbook workbook2;
     public String[][] arr;
}
