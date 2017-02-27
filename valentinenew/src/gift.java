/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * <h> Perform the gifting operation by boy according to nature of boy and maintenance budget of girl </h>
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author ARPITA AYUSHI
 */
public class gift {
    /**
     * <p> Read the required data from the saved file girls.xls and boys.xls at Document Folder of C:/ Drive </p>
     * <p> Perform gifting by boys</p>
     * <p> Save Output gifting.xls at Document Folder of C:/ Drive
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void gifting() throws FileNotFoundException, IOException{
        Workbook wb = new HSSFWorkbook();
        //XSSFWorkbook wb = new XSSFWorkbook();
    CreationHelper createhelper = wb.getCreationHelper();
    Sheet sheet = wb.createSheet("new sheet");
    Row row = null;
    Cell cell = null;
    row = sheet.createRow(0);
    cell = row.createCell(0);
    cell.setCellValue("Girl");
    cell = row.createCell(1);
    cell.setCellValue("Boy");
    cell = row.createCell(2);
    cell.setCellValue("Cost of gift");
    cell = row.createCell(3);
    cell.setCellValue("Luxury gift");
    cell = row.createCell(4);
    cell.setCellValue("Type of girl");
    cell = row.createCell(5);
    cell.setCellValue("Type of boy");
    cell = row.createCell(6);
    cell.setCellValue("Intelligence of girl");
    cell = row.createCell(7);
    cell.setCellValue("Value of Gift");
        workbook1 = null; workbook2 = null; workbook3 = null; workbook4 = null;
        data = new Vector();
        URL u1 = getClass().getResource("/girls.xls");
        URL u2 = getClass().getResource("/boys.xls");
        URL u3 = getClass().getResource("/couples.xls");
        URL u4 = getClass().getResource("/gifts.xls");
        JFileChooser jChooser = new JFileChooser();
        String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
    try {
        try {
            workbook1 = jxl.Workbook.getWorkbook(new File(doc+"\\girls.xls"));
            workbook2 = jxl.Workbook.getWorkbook(new File(doc+"\\boys.xls"));
            workbook3 = jxl.Workbook.getWorkbook(new File(doc+"\\couples.xls"));
            workbook4 = jxl.Workbook.getWorkbook(new File(doc+"\\gifts.xls"));
        } 
        catch (IOException ex) {
            Logger.getLogger(
                    gift.class.
                    getName()).log(Level.SEVERE,
                            null, ex);
        }
        jxl.Sheet sheet1 = workbook1.getSheet(0);
        jxl.Sheet sheet2 = workbook2.getSheet(0);
        jxl.Sheet sheet3 = workbook3.getSheet(0);
        jxl.Sheet sheet4 = workbook4.getSheet(0);
        data.clear();
        int k, v1, v2,v3,l,budget,min = 0, g_val, luxury;
        String s1, s2;
        jxl.Cell cell1, cell2, cell3, cell4;
        for (int j = 1; j < sheet3.getRows(); j++) {
            int found = 0;
            data.clear();
            cell1 = sheet1.getCell(0, j);
            row = sheet.createRow(j);
            cell = row.createCell(0);
            cell.setCellValue(cell1.getContents());
            cell1 = sheet1.getCell(5, j);
            cell = row.createCell(4);
            cell.setCellValue(cell1.getContents());
            cell1 = sheet1.getCell(3, j);
            cell = row.createCell(6);
            cell.setCellValue(cell1.getContents());
            cell1 = sheet1.getCell(2, j);
            cell3 = sheet3.getCell(1, j);
            s2 = cell3.getContents();
            cell = row.createCell(1);
            cell.setCellValue(s2);
            v1 = new Integer(Integer.parseInt(cell1.getContents().toString()));
            for (k = 1; k < sheet2.getRows(); k++) {
                 cell2 = sheet2.getCell(0, k);
                 s1 = cell2.getContents();
                 if(s1.equals(s2)){
                     found = 1;
                     break;
                 }
            }
            if(found==1){
                cell2 = sheet2.getCell(2, k);
                v2 =  new Integer(Integer.parseInt(cell2.getContents().toString()));
                cell2 = sheet2.getCell(5, k);
                cell = row.createCell(5);
                cell.setCellValue(cell2.getContents());
                budget = v2;
                int b =budget, c = 0;
                String st = cell2.getContents();
                switch(st){
                    case "Miser":
                    case "Geek":
                        c = budget-v1;
                        if(c<0)
                            c = 0;
                        break;
                    case "Generous":
                        c = 0;
                        break;
                }
                int m = 0;
                int miser_flag = 0;
                int min_v=0, vals = 0;
                luxury = 0;
                while(budget>c){
                    min=1000;
                    for(l=1;l<sheet4.getRows();l++){
                      cell4 = sheet4.getCell(2, l);
                      g_val = new Integer(Integer.parseInt(cell4.getContents().toString()));
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
                if(st.equals("Geek")){
                    min=budget;
                    for(l=1;l<sheet4.getRows();l++){
                        cell4 = sheet4.getCell(1, l);
                        String s = cell4.getContents();
                        if(s.equals("Luxury")){
                            cell4 = sheet4.getCell(2, l);
                            g_val = new Integer(Integer.parseInt(cell4.getContents().toString()));
                            cell4 = sheet4.getCell(3, l);
                            Integer val = new Integer(Integer.parseInt(cell4.getContents().toString()));
                            if(min > g_val){
                                min = g_val;
                                min_v = val;
                            }
                        }
                    }
                    luxury += min_v;
                    budget -= min;
                    vals+=min_v; 
                }
                cell = row.createCell(2);
                cell.setCellValue(b-budget);
                cell = row.createCell(3);
                cell.setCellValue(luxury);
                cell = row.createCell(7);
                cell.setCellValue(vals);
            }
            
        }
    }
            catch (BiffException e) {
        e.printStackTrace();
    }
    URL u = getClass().getResource("");
    FileOutputStream out2 = new FileOutputStream(doc+"\\gifting.xls");
    wb.write(out2);
    out2.close();
    }
    /*public static void main(String[] args) throws IOException {
        // TODO code application logic here
        gift v = new gift();
        v.gifting();
    }*/
    private Vector data;
    private jxl.Workbook workbook1,workbook2, workbook3, workbook4;
}