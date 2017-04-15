/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * <p> Calculate the happiness and compatibility<p>
 * <p> Inherited by boy and girl class to do individual calculation</p>
 * <p> Use Class gift to check gifting done by boys</p>
 * 
 */
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import jxl.read.biff.BiffException;

/**
 *
 * @author ARPITA AYUSHI
 */
public class happiness {
    /**
     * <p> Extract the file data of girls.xls, boys.xls and gifting.xls </p>
     *<p> inherited by boy class and girl class</p>
     * @param k 
     */
    public void hap_comp(int k){
        workbook1 = null; workbook2 = null; workbook3 = null; workbook4 = null;
        URL u1 = getClass().getResource("/girls.xls");
        URL u2 = getClass().getResource("/boys.xls");
        URL u3 = getClass().getResource("/gifting.xls");
        JFileChooser jChooser = new JFileChooser();
        String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
        try {
        try {
            workbook1 = jxl.Workbook.getWorkbook(new File(doc + "\\girls.xls"));
            workbook2 = jxl.Workbook.getWorkbook(new File(doc + "\\boys.xls"));
            workbook3 = jxl.Workbook.getWorkbook(new File(doc + "\\gifting.xls"));
        } 
        catch (IOException ex) {
            Logger.getLogger(
                    happiness.class.
                    getName()).log(Level.SEVERE,
                            null, ex);
        }
        sheet1 = workbook1.getSheet(0);
        sheet2 = workbook2.getSheet(0);
        sheet3 = workbook3.getSheet(0);
        data1 = new Vector();
        data2 = new Vector();
        data1.clear(); data2.clear();
        girl gl;
        boy by;
        for (int j = 1; j < sheet3.getRows(); j++) {
            cell3_1 = sheet3.getCell(4, j);
            String s3 = cell3_1.getContents();
            cell3_1 = sheet3.getCell(2, j);
            cell3_2 = sheet3.getCell(7, j);
            cell3_3 = sheet3.getCell(3, j);
            int sum=0;
            switch(s3){
                case "Normal":
                    gl = new normal();
                    sum = gl.happy(j);
                    //sum = new Integer(Integer.parseInt(cell3_1.getContents().toString())) + new Integer(Integer.parseInt(cell3_2.getContents().toString()));
                    break;
                case "Choosy":
                    //int v = new Integer(Integer.parseInt(cell3_1.getContents().toString()));
                    //sum = (int) Math.log10(v)+ 2* (new Integer(Integer.parseInt(cell3_3.getContents().toString())));
                    gl = new choosy();
                    sum =  gl.happy(j);
                    break;
                case "Desperate":
                   // v = new Integer(Integer.parseInt(cell3_1.getContents().toString()));
                   /// if(Math.exp(v)>100000)                                      //happiness set limit to 100000
                    //    sum = 100000;
                    gl = new desperate();
                    sum =  gl.happy(j);
                    break;        
            }
            cell3_1 = sheet3.getCell(5, j);
            s3 = cell3_1.getContents();
            switch(s3){
                case "Generous":
                    by = new generous();
                    sum*=by.happy(j);
                case "Miser":
                    /*cell3_2 = sheet3.getCell(1, j);
                    String b = cell3_2.getContents();
                    int i;
                    for( i=1; i<sheet2.getRows();i++){
                        cell2 = sheet2.getCell(0, i);
                        if(b.equals(cell2.getContents()))
                            break;
                    }
                    cell2 = sheet2.getCell(2,i);
                    int value = new Integer(Integer.parseInt(cell2.getContents().toString()));
                    cell3_2 = sheet3.getCell(2, j);
                    int val2 = new Integer(Integer.parseInt(cell3_2.getContents().toString()));
                    sum += value - val2;*/
                    by = new miser();
                    sum += by.happy(j);
                    break;
                case "Geek":
                    //cell3_2 = sheet3.getCell(6, j);
                    //sum +=  new Integer(Integer.parseInt(cell3_2.getContents().toString()));
                    by = new geek();
                    sum+= by.happy(j);
                    break;        
                }
                data1.add(sum);
                // compatible couples
                int comp = 0;
                cell1= sheet1.getCell(2, j);
                cell2= sheet2.getCell(2, j);
                int val1 = new Integer(Integer.parseInt(cell1.getContents().toString()));
                int val2 = new Integer(Integer.parseInt(cell2.getContents().toString()));
                comp = Math.abs(val2 - val1);
                cell1= sheet1.getCell(1, j);
                cell2= sheet2.getCell(1, j);
                val1 = new Integer(Integer.parseInt(cell1.getContents().toString()));
                val2 = new Integer(Integer.parseInt(cell2.getContents().toString()));
                comp += Math.abs(val1-val2);
                cell1= sheet1.getCell(3, j);
                cell2= sheet2.getCell(3, j);
                val1 = new Integer(Integer.parseInt(cell1.getContents().toString()));
                val2 = new Integer(Integer.parseInt(cell2.getContents().toString()));
                comp += Math.abs(val1-val2);
                data2.add(comp);
                
        }
                System.out.println("Happiness                         Compatible");
                System.out.println("Girl  Boy  Rate                   Girl  boy  Rate");
                //print
                Vector newv = new Vector();
                Vector newv1 = new Vector();
                int min, min1;
                int m = 0, n = 0;
                for(int i = 0; i<k;i++){
                    min = 0;
                    for(int f =0; f<data1.size();f++){
                        int ele = (int) data1.elementAt(f);
                        if(min < ele  && !newv.contains(ele)){
                            min = ele;
                            m = f;
                        }    
                    }
                    newv.add(min);
                    min1 = 0;
                    cell2 = sheet3.getCell(0, m+1);
                    cell1 = sheet3.getCell(1, m+1);
                    for(int f =0; f<data2.size();f++){
                        int ele = (int) data2.elementAt(f);
                        if(min1 < ele  && !newv1.contains(ele)){
                            min1 = ele;
                            n = f;
                        }    
                    }
                    newv1.add(min1);
                    cell3_2 = sheet3.getCell(0, n+1);
                    cell3_1 = sheet3.getCell(1, n+1);
                    System.out.println(cell2.getContents()+"    "+cell1.getContents()+"    "+min+"                "+cell3_2.getContents()+"    "+cell3_1.getContents()+"   "+min1);
                }
        }
            catch (BiffException e) {
        e.printStackTrace();
    }
    }
   
    public Vector data1,data2;
    public jxl.Workbook workbook1,workbook2, workbook3, workbook4;
    public jxl.Sheet sheet1,sheet2,sheet3;
    public jxl.Cell cell1, cell2, cell3_1, cell3_2, cell3_3;
}