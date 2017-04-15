/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * <p> It is an abstract class</p>
 * <p> Calculate the happiness and compatibility of the girl <p>
 * <p> Inherited by choosy, desperate and normal classes to do individual calculation</p>
 * 
 */
public abstract class girl extends happiness{
    /**
     * Calculate the happiness of classes that inherits it.
     * @param j
     * @return 
     */
    abstract public int happy(int j);
}
