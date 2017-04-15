
import java.io.File;
import java.io.IOException;
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
 * it is sorted array implementation to find girlfriends.
 * it inherits the class anonymous_method.
 * Implement all variants via inheritance and use upcasting to the base class
 * @author ARPITA AYUSHI
 */
public class sorted_array extends anonymous_method{
    public void sorted(){
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
        for(i=0;i<arr.length-1;i++){
            for(int j = 0 ; j<arr.length-i-1; j++ ){
                    if(new Integer(Integer.parseInt(arr[j][0].toString()))> new Integer(Integer.parseInt(arr[j+1][0].toString()))){
                        int temp = new Integer(Integer.parseInt(arr[j][0].toString()));
                        arr[j][0] = arr[j+1][0];
                        arr[j+1][0] = Integer.toString(temp);
                    }
            }
        }
    }
    /**
     * to do binary search
     * @param inputArr is the 2d array has name of couple(girl and boy). 
     * @param key is the name of boy in list from class random
     * @return 
     */
    public  int binarySearch(String[][] inputArr, String key) {
        int start = 0;
        int end = inputArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key.equals(inputArr[mid][0])) {
                return mid;
            }
            if (new Integer(Integer.parseInt(key)) < new Integer(Integer.parseInt(inputArr[mid][0]))) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
  
    /**
     * to store the information of girlfriends of various boys.
     * @param r is object of class random which contain the list of boys.
     */
    @Override
    public void couple(random r) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        sorted();
        int found = 0;
        for(int i=0;i<r.boys.size();i++){
            System.out.print("boy = "+r.boys.elementAt(i)+"  ");
            int j = binarySearch(arr, (String) r.boys.elementAt(i));
            if(j!= -1)
               System.out.println("girl = "+arr[j][1]);
            else
               System.out.println("girl = NOT COUPLE");
            
        }
    }
    private jxl.Workbook workbook2;
    public String[][] arr;
}
