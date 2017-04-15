/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Inherits the girl class and calculate the happiness of normal type of girls.
 * @author ARPITA  AYUSHI
 */
public class normal extends girl{
    /**
     * Calculate the happiness of normal type of girls.
     * @param j
     * @return 
     */
    @Override
    public int happy(int j) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cell3_1 = sheet3.getCell(2, j);
        cell3_2 = sheet3.getCell(7, j);
        cell3_3 = sheet3.getCell(3, j);
        return new Integer(Integer.parseInt(cell3_1.getContents().toString())) + new Integer(Integer.parseInt(cell3_2.getContents().toString()));
    }
    
}
