
import java.util.Vector;
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
 * it is used to write the various output after gifting is performed in .xls file
 * @author ARPITA AYUSHI
 */
public class write_gift {
    public void write(Extract e){
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
    cell = row.createCell(8);
    cell.setCellValue("Attraction level of girl");
    cell = row.createCell(9);
    cell.setCellValue("Maintenance level of girl");
    cell = row.createCell(10);
    cell.setCellValue("attraction req of boy");
    cell = row.createCell(11);
    cell.setCellValue("budget of boy");
    gift g;
    for(int i = 0;i<e.co_g.size();i++){
        Girl.add(e.co_g.elementAt(i));
        girl_Type.add(e.g_ty.elementAt(e.g_name.indexOf(e.co_g.elementAt(i))));
        girl_Intelligence.add(e.g_int.elementAt(e.g_name.indexOf(e.co_g.elementAt(i))));
         girl_attrac.add(e.g_att.elementAt(e.g_name.indexOf(e.co_g.elementAt(i))));
        maintanence.add(e.g_main.elementAt(e.g_name.indexOf(e.co_g.elementAt(i))));
        int j = e.b_name.indexOf(e.co_b.elementAt(i));
        Boy.add(e.co_b.elementAt(j));
        boy_Type.add(e.b_ty.elementAt(j));
        boy_attrac.add(e.b_att.elementAt(j));
        budget.add(e.b_main.elementAt(j));
        String s = (String) e.b_ty.elementAt(j);
        switch(s){
            case "Miser":
                g = new miser_gift();
                g.gifting(e, j, (int) e.g_main.elementAt(e.g_name.indexOf(e.co_g.elementAt(i))));
                gift_Cost.add(g.gift_Cost);
                Luxury_gift.add(g.Luxury_gift);
                Gift_Value.add(g.Gift_Value);
                break;
            case "Geek":
                g = new geek_gift();
                g.gifting(e, j, (int) e.g_main.elementAt(e.g_name.indexOf(e.co_g.elementAt(i))));
                gift_Cost.add(g.gift_Cost);
                Luxury_gift.add(g.Luxury_gift);
                Gift_Value.add(g.Gift_Value);
                break;
            case "Generous":
                g = new generous_gift();
                g.gifting(e, j, (int) e.g_main.elementAt(e.g_name.indexOf(e.co_g.elementAt(i))));
                gift_Cost.add(g.gift_Cost);
                Luxury_gift.add(g.Luxury_gift);
                Gift_Value.add(g.Gift_Value);
                break;
        }
    }
    for(int i = 0; i < Girl.size();i++){
        
    }
    }
    public Vector Girl,Boy,gift_Cost,Luxury_gift,girl_Type,boy_Type,girl_Intelligence,Gift_Value,girl_attrac,maintanence,boy_attrac,budget;
}
