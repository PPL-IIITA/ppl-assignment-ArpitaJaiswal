
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFileChooser;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * it is used to generate list of random boys.
 * @author ARPITA AYUSHI
 */
public class random {
    public void random_boys() throws IOException, BiffException{
        JFileChooser jChooser = new JFileChooser();
        boys = new Vector();
        String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
        workbook2 = jxl.Workbook.getWorkbook(new File(doc + "\\boys.xls"));
        jxl.Sheet sheet1 = workbook2.getSheet(0);
        jxl.Cell cell;
        boolean needToPickAgain;
        int io;
        Random randomno = new Random();
        int j;  
        for(int i =0;i<20;i++){
            do {
                 needToPickAgain=false;
                 io = randomno.nextInt();
                 j=Math.abs(io % sheet1.getRows());
                 if(j<1 || j>sheet1.getRows()-1)
                     needToPickAgain = true;
                 else{
                     cell = sheet1.getCell(0, j);
                     boys.add(cell.getContents());
                 }
                }while(needToPickAgain);
        }
    }
    private jxl.Workbook workbook2;
    public Vector boys;
}
