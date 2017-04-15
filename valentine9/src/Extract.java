
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
 * it is used to extract various information from .xls files and save it in vectors.
 * @author ARPITA AYUSHI
 */
public class Extract {
    public void extract() throws IOException, BiffException{
        JFileChooser jChooser = new JFileChooser();
        String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
        workbook1 = jxl.Workbook.getWorkbook(new File(doc +"\\girls.xls"));
        workbook2 = jxl.Workbook.getWorkbook(new File(doc +"\\boys.xls"));
        workbook3 = jxl.Workbook.getWorkbook(new File(doc +"\\gifts.xls"));
        workbook4 = jxl.Workbook.getWorkbook(new File(doc +"\\couples.xls"));
        jxl.Sheet sheet1 = workbook1.getSheet(0);
        jxl.Sheet sheet2 = workbook2.getSheet(0);
        jxl.Sheet sheet3 = workbook3.getSheet(0);
        jxl.Sheet sheet4 = workbook4.getSheet(0);
        jxl.Cell cell1;
        for (int j = 1; j < sheet1.getRows(); j++) {
            cell1 = sheet1.getCell(0, j);
            g_name.add(cell1.getContents());
            cell1 = sheet1.getCell(1, j);
            g_att.add(cell1.getContents());
            cell1 = sheet1.getCell(2, j);
            g_main.add(cell1.getContents());
            cell1 = sheet1.getCell(3, j);
            g_int.add(cell1.getContents());
            cell1 = sheet1.getCell(4, j);
            g_cri.add(cell1.getContents());
            cell1 = sheet1.getCell(5, j);
            g_ty.add(cell1.getContents());
            
        }
        for (int j = 1; j < sheet2.getRows(); j++) {
            cell1 = sheet1.getCell(0, j);
            b_name.add(cell1.getContents());
            cell1 = sheet1.getCell(1, j);
            b_att.add(cell1.getContents());
            cell1 = sheet1.getCell(2, j);
            b_main.add(cell1.getContents());
            cell1 = sheet1.getCell(3, j);
            b_int.add(cell1.getContents());
            cell1 = sheet1.getCell(4, j);
            b_cri.add(cell1.getContents());
            cell1 = sheet1.getCell(5, j);
            b_ty.add(cell1.getContents());
        }
        for (int j = 1; j < sheet3.getRows(); j++) {
            cell1 = sheet1.getCell(0, j);
            co_g.add(cell1.getContents());
            cell1 = sheet1.getCell(1, j);
            co_b.add(cell1.getContents());
        }
    }
    public Vector b_name, b_att,b_main,b_int,b_ty,b_cri;
    public Vector g_name, g_att,g_main,g_int,g_ty,g_cri;
    public Vector gi_name, gi_ty,gi_co,gi_val;
    public Vector co_g,co_b;
    public Vector Girl,Boy,gift_Cost,Luxury_gift,girl_Type,boy_Type,girl_Intelligence,Gift_Value,girl_attrac,maintanence,boy_attrac,budget;
    public jxl.Workbook workbook1,workbook2, workbook3, workbook4;
}
