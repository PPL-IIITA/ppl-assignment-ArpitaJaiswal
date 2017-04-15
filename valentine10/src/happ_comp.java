
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JFileChooser;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ARPITA AYUSHI
 */
public class happ_comp {
    public void cal(){}
    public void extract() throws IOException, BiffException{
        workbook1 = null;
        JFileChooser jChooser = new JFileChooser();
        String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
        workbook4 = jxl.Workbook.getWorkbook(new File(doc +"\\gifting.xls"));
        jxl.Sheet sheet1 = workbook1.getSheet(0);
        jxl.Cell cell1;
        for (int j = 1; j < sheet1.getRows(); j++) {
            cell1 = sheet1.getCell(0, j);
            Girl.add(cell1.getContents());
            cell1 = sheet1.getCell(1, j);
            Boy.add(cell1.getContents());
            cell1 = sheet1.getCell(2, j);
            gift_Cost.add(cell1.getContents());
            cell1 = sheet1.getCell(3, j);
            Luxury_gift.add(cell1.getContents());
            cell1 = sheet1.getCell(4, j);
            girl_Type.add(cell1.getContents());
            cell1 = sheet1.getCell(5, j);
            boy_Type.add(cell1.getContents());
            cell1 = sheet1.getCell(6, j);
            girl_Intelligence.add(cell1.getContents());
            cell1 = sheet1.getCell(7, j);
            Gift_Value.add(cell1.getContents());
            cell1 = sheet1.getCell(8, j);
            girl_attrac.add(cell1.getContents());
            cell1 = sheet1.getCell(9, j);
            maintanence.add(cell1.getContents());
            cell1 = sheet1.getCell(10, j);
            boy_attrac.add(cell1.getContents());
            cell1 = sheet1.getCell(11, j);
            budget.add(cell1.getContents());
        }
    }
    public Vector Girl,Boy,gift_Cost,Luxury_gift,girl_Type,boy_Type,girl_Intelligence,Gift_Value,girl_attrac,maintanence,boy_attrac,budget;
    public jxl.Workbook workbook1,workbook2, workbook3, workbook4;
}
