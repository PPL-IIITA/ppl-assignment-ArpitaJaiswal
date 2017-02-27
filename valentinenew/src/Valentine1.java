/**
 * <h> Solution to question 1 </h>
 * <p> It extract girls.xls and boys.xls created by  Class Random saved at Document Folder of C:\ Drive </p>
 * <p> It prints and save couple.xls at Document folder of C:/ Drive </p>
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.io.IOException;
import java.net.URL;
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

public class Valentine1 {
    /**
     * 
     * @param file1
     * @param file2
     * <p> file1 and file2 are excel File of girl and boy respectively
     * @throws BiffException
     * @throws FileNotFoundException
     * @throws IOException 
     * <p> save the couples.xls file in Document folder
     */
    public void fillData(File file1, File file2) throws BiffException, FileNotFoundException, IOException{
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
        workbook1 = null; workbook2 = null;
        data = new Vector();
    try {
        try {
            workbook1 = jxl.Workbook.getWorkbook(file1);
            workbook2 = jxl.Workbook.getWorkbook(file2);
        } catch (IOException ex) {
            Logger.getLogger(
                    Valentine1.class.
                    getName()).log(Level.SEVERE,
                            null, ex);
        }
        jxl.Sheet sheet1 = workbook1.getSheet(0);
        jxl.Sheet sheet2 = workbook2.getSheet(0);
        data.clear();
        int k, v1, v2, count = 0;
        String s1, s2;
        jxl.Cell cell1, cell2;
        
        System.out.println("GIRLS   BOYS");
        for (int j = 1; j < sheet1.getRows(); j++) {
            Vector d = new Vector();
            k = 0;
            int match = 0;
            cell1 = sheet1.getCell(0, j);
            System.out.print(cell1.getContents()+"     ");
             row = sheet.createRow(j);
             cell = row.createCell(0);
             cell.setCellValue(cell1.getContents());
             cell = row.createCell(1);
            for (k = 1; k < sheet2.getRows(); k++) {

                 cell1 = sheet1.getCell(1, j);
                 cell2 = sheet2.getCell(4, k);
                 v1 = new Integer(Integer.parseInt(cell1.getContents().toString()));
                 v2 = new Integer(Integer.parseInt(cell2.getContents().toString()));
                 if(v1 < v2)
                     continue;
                 cell1 = sheet1.getCell(2, j);
                 cell2 = sheet2.getCell(2, k);
                 v1 = new Integer(Integer.parseInt(cell1.getContents().toString()));
                 v2 = new Integer(Integer.parseInt(cell2.getContents().toString()));
                  if(v1 > v2)
                     continue;
                cell1 = sheet1.getCell(4, j);
                s1 = cell1.getContents();
                switch(s1){
                    case "Intelligent":
                        cell2 = sheet2.getCell(3, k);
                        v2 = new Integer(Integer.parseInt(cell2.getContents().toString()));
                        if(v2>5){
                            match = 1;
                        }
                        break;
                    case "Attractive":
                        cell2 = sheet2.getCell(1, k);
                        v2 = new Integer(Integer.parseInt(cell2.getContents().toString()));
                        if(v2>5){
                            match = 1;
                        }
                        break;
                    case "Rich":
                        cell2 = sheet2.getCell(2, k);
                        v2 = new Integer(Integer.parseInt(cell2.getContents().toString()));
                        if(v2>700){
                            match = 1;
                        }
                        break;
                }
                int i;
                if(match==1){
                    cell2 = sheet2.getCell(0, k);
                    s2 = cell2.getContents();
                    for(i=0; i<data.size(); i++){
                        if(s2.equals(data.elementAt(i))){ 
                            match = 0;
                            break;
                        }
                    }
                    if(match == 1){
                     data.add(cell2.getContents());
                     System.out.print(cell2.getContents());
                     cell.setCellValue(cell2.getContents());
                     count++;
                     break;
                    }
                }
            }
            System.out.println();
        }
        System.out.println("Number of couple formed = "+ count);
    }
            catch (BiffException e) {
        e.printStackTrace();
    }
    URL u1 = getClass().getResource("");
    JFileChooser jChooser = new JFileChooser();
    String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
    FileOutputStream out = new FileOutputStream(doc+"\\couples.xls");
    wb.write(out);
    out.close();
    }
    /**
     * <p> open the files girls.xls and boys.xls and send file parameter to filldata()
     * @throws BiffException
     * @throws IOException 
     */

   public void open() throws BiffException, IOException{
            URL u1 = getClass().getResource("/girls.xls");
            URL u2 = getClass().getResource("/boys.xls");
            JFileChooser jChooser = new JFileChooser();
            String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
            File file1 = new File(doc+"\\girls.xls");
            File file2 = new File(doc+"\\boys.xls");
            fillData(file1,file2);
    }
    public static void main(String[] args) throws BiffException, IOException {
       random v1 = new random();
        v1.action();
        Valentine1 v = new Valentine1();
        v.open();
    }
    private Vector data;
    private jxl.Workbook workbook1,workbook2;
}
