
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
 * Inherits the girl class and calculate the happiness of choosy type of girls.
 * @author ARPITA  AYUSHI
 */
public class choosy extends girl{
     /**
     * Calculate the happiness of choosy type of girls.
     * @param j
     * @return 
     */
    public int happy(int j) {
        JFileChooser jChooser = new JFileChooser();
        String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
       
        try {
            workbook1 = jxl.Workbook.getWorkbook(new File(doc + "\\girls.xls"));
        } catch (IOException ex) {
            Logger.getLogger(normal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(normal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            workbook2 = jxl.Workbook.getWorkbook(new File(doc + "\\boys.xls"));
        } catch (IOException ex) {
            Logger.getLogger(normal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(normal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            workbook3 = jxl.Workbook.getWorkbook(new File(doc + "\\gifting.xls"));
        } catch (IOException ex) {
            Logger.getLogger(normal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(normal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sheet1 = workbook1.getSheet(0);
        sheet2 = workbook2.getSheet(0);
        sheet3 = workbook3.getSheet(0);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cell3_1 = sheet3.getCell(2, j);
        cell3_2 = sheet3.getCell(7, j);
        cell3_3 = sheet3.getCell(3, j);
        int v = new Integer(Integer.parseInt(cell3_1.getContents().toString()));
        return (int) Math.log10(v)+ 2* (new Integer(Integer.parseInt(cell3_3.getContents().toString())));
    }
    public jxl.Workbook workbook1,workbook2, workbook3, workbook4;
    public jxl.Sheet sheet1,sheet2,sheet3;
    public jxl.Cell cell1, cell2, cell3_1, cell3_2, cell3_3;
}
