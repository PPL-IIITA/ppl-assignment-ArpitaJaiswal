
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * <p> It extract girls.xls and boys.xls saved at Document Folder of C:\ Drive </p>
 * <p> It prints and save q5_couples_using_q1.xls at Document folder of C:/ Drive </p>
 * 
 */
public class couple {
     /**
     * forms the new couple which is not the previous couple for k least happiest couple.
     * save output q5_couples_using_q4.xls in Document folder of C:/Drive.
     * @param e is passing the object of class extract which is being called in main so as to use the information of k Least happiest couple (which includes the vectors 'newv and newv1' for name of girl and boy).
     * @param times is iteration constant, for condition of least happiest couple should not be performed for 1st time.
     * @throws BiffException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void newcouple(extract e, int times) throws BiffException, FileNotFoundException, IOException{
        Workbook wb = new HSSFWorkbook();
        //e = new extract();
         JFileChooser jChooser = new JFileChooser();
        String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
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
            workbook1 = jxl.Workbook.getWorkbook(new File(doc + "\\girls.xls"));
            workbook2 = jxl.Workbook.getWorkbook(new File(doc + "\\boys.xls"));
        } catch (IOException ex) {
            Logger.getLogger(
                    couple.class.
                    getName()).log(Level.SEVERE,
                            null, ex);
        }
        jxl.Sheet sheet1 = workbook1.getSheet(0);
        jxl.Sheet sheet2 = workbook2.getSheet(0);
        data.clear();
        int k, v1, v2, count = 0;
        String s1, s2;
        jxl.Cell cell1, cell2;
        System.out.println();
        System.out.println("New Couples formed");
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
                 cell2 = sheet2.getCell(0, k);
                 if(times!=0)
                 if(e.newv1.contains(cell2.getContents()))
                     continue;
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
            catch (BiffException rt) {
        rt.printStackTrace();
    }
    URL u1 = getClass().getResource("");
   // JFileChooser jChooser = new JFileChooser();
    //jChooser.getFileSystemView().
    //String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
    FileOutputStream out = new FileOutputStream(doc+"\\couplesnew_q6.xls");
    wb.write(out);
    out.close();
    }
    private Vector data;
    private jxl.Workbook workbook1,workbook2;
    //extract e;
}
