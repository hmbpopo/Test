/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matthewawbreyprogram6;

/**
 *
 * @author Matt
 */
public class LLNode {
    
    private int number;
    
    public LLNode next;
    public LLNode prev;
    
    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    
    public int display(){
        return number;
    }
}
