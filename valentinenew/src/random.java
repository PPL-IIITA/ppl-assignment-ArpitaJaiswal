/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * <h> Generate the excel files for girl, boy, gift and Save it in the Document Folder of C:\ Drive  </h>
 */

import java.io.File;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 *
 * @author ARPITA AYUSHI
 */
public class random {
    //private org.apache.poi.ss.usermodel.Workbook wb = new org.apache.poi.hssf.usermodel.HSSFWorkbook();
    protected void action() throws FileNotFoundException, IOException{
        Workbook wb = new HSSFWorkbook();
        //XSSFWorkbook wb = new XSSFWorkbook();
    CreationHelper createhelper = wb.getCreationHelper();
    Sheet sheet = wb.createSheet("new sheet");
    Row row = null;
    Cell cell = null;
    row = sheet.createRow(0);
    cell = row.createCell(0);
    cell.setCellValue("Name");
    cell = row.createCell(1);
    cell.setCellValue("Attractiveness");
    cell = row.createCell(2);
    cell.setCellValue("Maintenance budget");
    cell = row.createCell(3);
    cell.setCellValue("Intelligentence level");
    cell = row.createCell(4);
    cell.setCellValue("Criteria of choosing boyfriend");
    cell = row.createCell(5);
    cell.setCellValue("Type If committed");
    boolean needToPickAgain;
    int io;
    Random randomno = new Random();
    int j;       
    for(int i = 1; i<51; i++){
        row = sheet.createRow(i);
        cell = row.createCell(0);
        cell.setCellValue(i);
        cell = row.createCell(1);
        do {
             needToPickAgain=false;
             io = randomno.nextInt();
             j=Math.abs(io % 11);
             if(j<1 || j>11)
                 needToPickAgain = true;
             else{
                 cell.setCellValue(j);
             }
            }while(needToPickAgain);
        cell = row.createCell(2);
        do {
             needToPickAgain=false;
             io = randomno.nextInt();
             j=Math.abs(io % 1001);
             if(j<100 || j>1001)
                 needToPickAgain = true;
             else{
                 cell.setCellValue(j);
             }
            }while(needToPickAgain);
        cell = row.createCell(3);
        do {
             needToPickAgain=false;
             io = randomno.nextInt();
             j=Math.abs(io % 11);
             if(j<1 || j>11)
                 needToPickAgain = true;
             else{
                 cell.setCellValue(j);
             }
            }while(needToPickAgain);
        cell = row.createCell(4);
        String s = null;
        do {
             needToPickAgain=false;
             io = randomno.nextInt();
             j=Math.abs(io % 3);
             if(j<0 || j>2)
                 needToPickAgain = true;
             else{
                 switch(j){
                     case 0:
                         s = "Intelligent";
                         break;
                     case 1:
                         s = "Attractive";
                         break;
                     case 2:
                         s = "Rich";
                         break;
                 }
                 cell.setCellValue(s);
             }
            }while(needToPickAgain);
        cell = row.createCell(5);
        s = null;
        do {
             needToPickAgain=false;
             io = randomno.nextInt();
             j=Math.abs(io % 3);
             if(j<0 || j>2)
                 needToPickAgain = true;
             else{
                 switch(j){
                     case 0:
                         s = "Choosy";
                         break;
                     case 1:
                         s = "Normal";
                         break;
                     case 2:
                         s = "Desperate";
                         break;
                 }
                 cell.setCellValue(s);
             }
            }while(needToPickAgain);
    }
    jChooser = new JFileChooser();
    String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
    //System.out.println(doc+"\\girls.xls");
    URL u = getClass().getResource("");
    FileOutputStream out = new FileOutputStream(doc+"\\girls.xls");
    wb.write(out);
    out.close();
    Workbook wb1 = new HSSFWorkbook();
        //XSSFWorkbook wb = new XSSFWorkbook();
    CreationHelper createhelper1 = wb1.getCreationHelper();
    Sheet sheet1 = wb1.createSheet("new sheet");
    Row row1 = null;
    Cell cell1 = null;
    row1 = sheet1.createRow(0);
    cell1 = row1.createCell(0);
    cell1.setCellValue("Name");
    cell1 = row1.createCell(1);
    cell1.setCellValue("Attractiveness");
    cell1 = row1.createCell(2);
    cell1.setCellValue("Budget");
    cell1 = row1.createCell(3);
    cell1.setCellValue("Intelligentence");
    cell1 = row1.createCell(4);
    cell1.setCellValue("Required attraction  level for choosing girlfriend"); 
    cell1 = row1.createCell(5);
    cell1.setCellValue("Type if committed"); 
    for(int k = 1; k<181; k++){
        row1 = sheet1.createRow(k);
        cell1 = row1.createCell(0);
        cell1.setCellValue(k);
        cell1 = row1.createCell(1);
        do {
             needToPickAgain=false;
             io = randomno.nextInt();
             j=Math.abs(io % 11);
             if(j<1 || j>11)
                 needToPickAgain = true;
             else{
                 cell1.setCellValue(j);
             }
            }while(needToPickAgain);
        cell1 = row1.createCell(2);
        do {
             needToPickAgain=false;
             io = randomno.nextInt();
             j=Math.abs(io % 1801);
             if(j<200 || j>1800)
                 needToPickAgain = true;
             else{
                 cell1.setCellValue(j);
             }
            }while(needToPickAgain);
        cell1 = row1.createCell(3);
        do {
             needToPickAgain=false;
             io = randomno.nextInt();
             j=Math.abs(io % 11);
             if(j<1 || j>11)
                 needToPickAgain = true;
             else{
                 cell1.setCellValue(j);
             }
            }while(needToPickAgain);
        cell1 = row1.createCell(4);
         do {
             needToPickAgain=false;
             io = randomno.nextInt();
             j=Math.abs(io % 11);
             if(j<1 || j>11)
                 needToPickAgain = true;
             else{
                 cell1.setCellValue(j);
             }
            }while(needToPickAgain);
         cell1 = row1.createCell(5);
        String s = null;
        do {
             needToPickAgain=false;
             io = randomno.nextInt();
             j=Math.abs(io % 3);
             if(j<0 || j>2)
                 needToPickAgain = true;
             else{
                 switch(j){
                     case 0:
                         s = "Miser";
                         break;
                     case 1:
                         s = "Generous";
                         break;
                     case 2:
                         s = "Geek";
                         break;
                 }
                 cell1.setCellValue(s);
             }
            }while(needToPickAgain);
     URL u2 = getClass().getResource("");
    FileOutputStream out1 = new FileOutputStream(doc+"\\boys.xls");
    wb1.write(out1);
    out1.close();
    }
    row = null;
    cell = null;
    row = sheet.createRow(0);
    cell = row.createCell(0);
    cell.setCellValue("Gift");
    cell = row.createCell(1);
    cell.setCellValue("Type");
    cell = row.createCell(2);
    cell.setCellValue("Cost");
    cell = row.createCell(3);
    cell.setCellValue("Value");
    for(int i = 1; i<31; i++){
        row = sheet.createRow(i);
        cell = row.createCell(0);
        cell.setCellValue(i);
        cell = row.createCell(1);
        String s = null;
        do {
             needToPickAgain=false;
             io = randomno.nextInt();
             j=Math.abs(io % 3);
             if(j<0 || j>2)
                 needToPickAgain = true;
             else{
                 switch(j){
                     case 0:
                         s = "Essential";
                         break;
                     case 1:
                         s = "Luxury";
                         break;
                     case 2:
                         s = "Utility";
                         break;
                 }
                 cell.setCellValue(s);
             }
            }while(needToPickAgain);
        cell = row.createCell(2);
        do {
             needToPickAgain=false;
             switch(s){
                     case "Essential":
                         needToPickAgain=false;
                         io = randomno.nextInt();
                         j=Math.abs(io % 100);
                         if(j<30 || j>101)
                              needToPickAgain = true;
                         else
                            cell.setCellValue(j);
                         break;
                     case "Luxury":
                         needToPickAgain=false;
                         io = randomno.nextInt();
                         j=Math.abs(io % 900);
                         if(j<300 || j>900)
                              needToPickAgain = true;
                         else
                            cell.setCellValue(j);
                         break;
                     case "Utility":
                         needToPickAgain=false;
                         io = randomno.nextInt();
                         j=Math.abs(io % 301);
                         if(j<100 || j>300)
                              needToPickAgain = true;
                         else
                            cell.setCellValue(j);
                         break;
                 }
            }while(needToPickAgain);
        cell = row.createCell(3);
        do {
             needToPickAgain=false;
             switch(s){
                     case "Essential":
                         needToPickAgain=false;
                         io = randomno.nextInt();
                         j=Math.abs(io % 100);
                         if(j<30 || j>101)
                              needToPickAgain = true;
                         else
                            cell.setCellValue(j);
                         break;
                     case "Luxury":
                         needToPickAgain=false;
                         io = randomno.nextInt();
                         j=Math.abs(io % 900);
                         if(j<300 || j>900)
                              needToPickAgain = true;
                         else
                            cell.setCellValue(j);
                         break;
                     case "Utility":
                         needToPickAgain=false;
                         io = randomno.nextInt();
                         j=Math.abs(io % 301);
                         if(j<100 || j>300)
                              needToPickAgain = true;
                         else
                            cell.setCellValue(j);
                         break;
                 }
            }while(needToPickAgain);
    }
    URL u1 = getClass().getResource("");
    FileOutputStream out2 = new FileOutputStream(doc+"\\gifts.xls");
    wb.write(out2);
    out2.close();
  }
   /* public static void main(String[] args) throws IOException {
        // TODO code application logic here
        random v = new random();
        v.action();
    }*/
    private JFileChooser jChooser;
}
    
