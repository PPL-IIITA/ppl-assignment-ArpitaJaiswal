/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ARPITA AYUSHI
 */
/**
 * Inherits the boy class and calculate the happiness of miser type of boys
 * @author ARPITA  AYUSHI
 */
public class miser extends boy{
    /**
     * Calculate the happiness of miser type of boys.
     * @param j
     * @return 
     */
    @Override
    public int happy(int j) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cell3_1 = sheet3.getCell(5, j);
        String s3 = cell3_1.getContents();
        cell3_2 = sheet3.getCell(1, j);
                    String b = cell3_2.getContents();
                    int i;
                    for( i=1; i<sheet2.getRows();i++){
                        cell2 = sheet2.getCell(0, i);
                        if(b.equals(cell2.getContents()))
                            break;
                    }
                    cell2 = sheet2.getCell(2,i);
                    int value = new Integer(Integer.parseInt(cell2.getContents().toString()));
                    cell3_2 = sheet3.getCell(2, j);
                    int val2 = new Integer(Integer.parseInt(cell3_2.getContents().toString()));
        return value-val2;
    }
    
}
