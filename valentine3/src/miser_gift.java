
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import jxl.read.biff.BiffException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Inherits the happ_comp class to get the various data required for gifting.
 * perform gifting by miser.
 * @author ARPITA AYUSHI
 */
public class miser_gift extends happ_comp{
    /**
     * perform gifting by miser.
     * @param c
     * c is maintenence of girl.
     * @param budget
     * budget of miser boy.
     * @param row
     * @param cell
     * @throws IOException
     * @throws BiffException 
     */
    public void giftI(int c, int budget, Row row, Cell  cell) throws IOException, BiffException{
        g.jio();
        JFileChooser jChooser = new JFileChooser();
        String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
        
            workbook1 = jxl.Workbook.getWorkbook(new File(doc+"\\girls.xls"));
            workbook2 = jxl.Workbook.getWorkbook(new File(doc+"\\boys.xls"));
            workbook3 = jxl.Workbook.getWorkbook(new File(doc+"\\couples.xls"));
            workbook4 = jxl.Workbook.getWorkbook(new File(doc+"\\gifts.xls"));
        
        sheet1 = workbook1.getSheet(0);
        sheet2 = workbook2.getSheet(0);
        sheet3 = workbook3.getSheet(0);
        sheet4 = workbook4.getSheet(0);
        Vector data = new Vector();
        int b = budget;
        int m = 0;
       // v = new Vector();
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
                
                //cell = row.createCell(2);
                g.vt.add(b-budget);
                //cell = row.createCell(3);
                g.vt.add(luxury);
                //cell = row.createCell(7);
                g.vt.add(vals);
            }
    public jxl.Workbook workbook1,workbook2, workbook3, workbook4;
    public jxl.Sheet sheet1,sheet2,sheet3,sheet4;
    public jxl.Cell cell1, cell2, cell3_1, cell3_2, cell3_3,cell3,cell4;
    }

