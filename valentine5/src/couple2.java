
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
 *  it forms new couples for the k least happiest couples.
 * @author ARPITA AYUSHI
 */
public class couple2 {
    /**
     * forms the new couple which is not the previous couple for k least happiest couple.
     * save output q5_couples_using_q4.xls in Document folder of C:/Drive.
     * @param e is passing the object of class extract which is being called in main so as to use the information of k Least happiest couple (which includes the vectors 'newv and newv1' for name of girl and boy).
     * @throws BiffException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void couple_formed(extract e) throws BiffException, FileNotFoundException, IOException{
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
                    couple1.class.
                    getName()).log(Level.SEVERE,
                            null, ex);
        }
        jxl.Sheet sheet1 = workbook1.getSheet(0);
        jxl.Sheet sheet2 = workbook2.getSheet(0);
        data.clear();
        int k, v1, v2, count = 0;
        String s1, s2;
        jxl.Cell cell1, cell2 = null;
        System.out.println();
        System.out.println("New Couples formed");
        System.out.println("GIRLS   BOYS");
        int size = 0, choose = 0,j,n=1,max = 0;
        Vector boy = new Vector();
        Vector girl = new Vector();
        Vector attrac= new Vector();
        while(size < sheet1.getRows()-1){
            //row = sheet.createRow(n++);
            if(choose==0){
                for(j=1;j<sheet1.getRows();j++)
                    if(!girl.contains(j)){
                        girl.add(j);
                        size = girl.size();
                        cell1 = sheet1.getCell(0, j);
                        //cell = row.createCell(0);
                       // cell.setCellValue(cell1.getContents());
                        System.out.print(cell1.getContents()+"  ");
                        break;
                    }
                choose = 1;      
                for (k = 1; k < sheet2.getRows(); k++) {
                    if(boy.contains(k))
                        continue;
                    cell2 = sheet2.getCell(0, k);
                    if(e.newv1.contains(cell2.getContents()))
                            continue;
                    cell1 = sheet1.getCell(2, j);
                    cell2 = sheet2.getCell(2, k);
                    v1 = new Integer(Integer.parseInt(cell1.getContents().toString()));
                    v2 = new Integer(Integer.parseInt(cell2.getContents().toString()));
                    if(v1 < v2)
                         break;
                }
                boy.add(k);
                cell2 = sheet2.getCell(0, k);
                //cell = row.createCell(1);
                //cell.setCellValue(cell2.getContents());
                System.out.println(cell2.getContents());
            }
            
            
            if(choose==1){
                for(j=1;j<sheet2.getRows();j++)
                    if(!boy.contains(j)){
                        boy.add(j);
                        cell2 = sheet2.getCell(0, j);
                        
                        break;
                    }
                choose = 0;
                max = 0;
                int l = -1;
                for (k = 1; k < sheet1.getRows(); k++) {
                    if(girl.contains(k))
                        continue;
                    cell1 = sheet1.getCell(0, k);
                    if(e.newv1.contains(cell1.getContents()))
                            continue;
                    cell1 = sheet1.getCell(1, k);
                    v1 = new Integer(Integer.parseInt(cell1.getContents().toString()));
                    if(v1 > max){
                         max = v1;
                         l = k;
                    }
                }
                if(l==-1)
                    break;
                //System.out.println("k "+l);
                girl.add(l);
                size = girl.size();
                cell1 = sheet1.getCell(0, l);
                //cell = row.createCell(0);
               // cell.setCellValue(cell1.getContents());
                System.out.print(cell1.getContents()+"  ");
               // cell = row.createCell(1);
               // cell.setCellValue(cell2.getContents());
                System.out.println(cell2.getContents());
            }
        }
        int temp;
        for(int i=0;i<girl.size()-1;i++){
           for(j=0;j<girl.size()-i-1;j++){
               if((int)girl.elementAt(j) > (int)girl.elementAt(j+1)){
                   temp = (int)girl.elementAt(j);
                   girl.setElementAt(girl.elementAt(j+1), j);
                   girl.setElementAt(temp, j+1);
                   temp = (int)boy.elementAt(j);
                   boy.setElementAt(boy.elementAt(j+1), j);
                   boy.setElementAt(temp, j+1);
               } 
           }
            
        }
        for(int i=0;i<girl.size()-1;i++){
           row = sheet.createRow(i+1);
           cell1 = sheet1.getCell(0, (int)girl.elementAt(i));
           cell = row.createCell(0);
           cell.setCellValue(cell1.getContents());
           cell1 = sheet2.getCell(0, (int)boy.elementAt(i));
           cell = row.createCell(1);
           cell.setCellValue(cell1.getContents());
        }
        System.out.println("Number of couple formed = "+ size);
    }
            catch (BiffException rt) {
        rt.printStackTrace();
    }
    URL u1 = getClass().getResource("");
   // JFileChooser jChooser = new JFileChooser();
    //jChooser.getFileSystemView().
    //String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
    FileOutputStream out = new FileOutputStream(doc+"\\q5_couples_using_q4.xls");
    wb.write(out);
    out.close();
    }
    private Vector data;
    private jxl.Workbook workbook1,workbook2;
}
