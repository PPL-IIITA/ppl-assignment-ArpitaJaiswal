/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Inherits the girl class and calculate the happiness of desperate type of girls.
 * @author ARPITA  AYUSHI
 */
public class desperate extends girl{
    /**
     * Calculate the happiness of desperate type of girls.
     * @param j
     * @return 
     */
    public int happy(int j) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cell3_1 = sheet3.getCell(2, j);
        cell3_2 = sheet3.getCell(7, j);
        cell3_3 = sheet3.getCell(3, j);
        int v  = new Integer(Integer.parseInt(cell3_1.getContents().toString()));
                    if(Math.exp(v)>100000)                                      //happiness set limit to 100000
                        return 100000;
                    else return v;
    }
}
