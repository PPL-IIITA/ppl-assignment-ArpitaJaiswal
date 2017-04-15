/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * <p> Calculate the happiness and compatibility<p>
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
public class Happiness {
    /**
     * <p> Extract the file data of girls.xls, boys.xls and gifting4.xls</p>
     * <p> Calculate happiness of the couples</p>
     */
    public void hap_comp(){
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
            workbook3 = jxl.Workbook.getWorkbook(new File(doc + "\\gifting4.xls"));
        } 
        catch (IOException ex) {
            Logger.getLogger(
                    Happiness.class.
                    getName()).log(Level.SEVERE,
                            null, ex);
        }
        jxl.Sheet sheet1 = workbook1.getSheet(0);
        jxl.Sheet sheet2 = workbook2.getSheet(0);
        jxl.Sheet sheet3 = workbook3.getSheet(0);
        data1 = new Vector();
        data2 = new Vector();
        data1.clear(); data2.clear();
        jxl.Cell cell1, cell2, cell3_1, cell3_2, cell3_3;
        for (int j = 1; j < sheet3.getRows(); j++) {
            cell3_1 = sheet3.getCell(4, j);
            String s3 = cell3_1.getContents();
            cell3_1 = sheet3.getCell(2, j);
            cell3_2 = sheet3.getCell(7, j);
            cell3_3 = sheet3.getCell(3, j);
            int sum=0;
            switch(s3){
                case "Normal":
                    sum = new Integer(Integer.parseInt(cell3_1.getContents().toString())) + new Integer(Integer.parseInt(cell3_2.getContents().toString()));
                    break;
                case "Choosy":
                    int v = new Integer(Integer.parseInt(cell3_1.getContents().toString()));
                    sum = (int) Math.log10(v)+ 2* (new Integer(Integer.parseInt(cell3_3.getContents().toString())));
                    break;
                case "Desperate":
                    v = new Integer(Integer.parseInt(cell3_1.getContents().toString()));
                    if(Math.exp(v)>100000)                                      //happiness set limit to 100000
                        sum = 100000;
                    break;        
            }
            cell3_1 = sheet3.getCell(5, j);
            s3 = cell3_1.getContents();
            switch(s3){
                case "Generous":
                    sum*=2;
                case "Miser":
                    cell3_2 = sheet3.getCell(1, j);
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
                    sum += value - val2;
                    break;
                case "Geek":
                    cell3_2 = sheet3.getCell(6, j);
                    sum +=  new Integer(Integer.parseInt(cell3_2.getContents().toString()));
                    break;        
                }
                data1.add(sum);
                
        }
                System.out.println("\n");
                System.out.println("Happiness");
                System.out.println("Girl  Boy  Rate");
                //print
                Vector newv = new Vector();
                Vector newv1 = new Vector();
                int min, min1;
                int m = 0, n = 0;
                for(int p=0;p<data1.size();p++){
                    cell2 = sheet3.getCell(0, p+1);
                    cell1 = sheet3.getCell(1, p+1);
                    System.out.println(cell2.getContents()+"    "+cell1.getContents()+"    "+data1.elementAt(p));
                }
                /*for(int i = 1; i<sheet3.getRows();i++){
                    min = 0;
                    for(int f =0; f<data1.size();f++){
                        int ele = (int) data1.elementAt(f);
                        if(min < ele  && !newv.contains(ele)){
                            min = ele;
                            m = f;
                        }    
                    }
                    newv.add(min);
                    cell2 = sheet3.getCell(0, m+1);
                    cell1 = sheet3.getCell(1, m+1);
                    System.out.println(cell2.getContents()+"    "+cell1.getContents()+"    "+min);
                }*/
        }
            catch (BiffException e) {
        e.printStackTrace();
    }
    }
    
    private Vector data1,data2;
    private jxl.Workbook workbook1,workbook2, workbook3, workbook4;
}