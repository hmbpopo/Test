/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matthewawbreyprogram6;

/**
 *
 * @author Matt
 */
public class MergeSortLL {
    
    private LLNode masterList;
    private LLNode[] darray = new LLNode[2];
    private int counter;
    
    public MergeSortLL(LLNode start){
        masterList = start;
    }
    
    public LLNode[] removeFront(LLNode list){
        LLNode temp;
        LLNode[] dar = new LLNode[2];
        temp = list;
        
        list = list.next;
        temp.next = null;
        temp.prev = null;
        
        if(list!=null)
            list.prev = null;
        
        dar[0] = temp;
        dar[1] = list;
        return dar;
    }
    
    public LLNode insertFront(LLNode list, LLNode item){
        if(list != null){
            item.next = list;
            list.prev = item;
        }
        
        return item;
    }
    
    public LLNode insertBack(LLNode list, LLNode item){
        LLNode temp;
        
        if(list != null){
            temp = list;
            while(temp.next != null)
                temp = temp.next;
            
            temp.next = item;
            item.prev = temp;
        }
        else
            list = item;
        return list;
    }
    
    private LLNode sort(LLNode myNode){
        LLNode oddList = null;
        LLNode evenList = null;
        LLNode temp;
        
        while(myNode != null){
            darray = removeFront(myNode);
            temp = darray[0];
            myNode = darray[1];
            oddList = insertFront(oddList, temp);
            if(myNode != null){
                darray = removeFront(myNode);
                temp = darray[0];
                myNode = darray[1];
                evenList = insertFront(evenList, temp);
            }
        }
        
        if(oddList != null && oddList.next != null)
            oddList = sort(oddList);
        if(evenList != null && evenList.next != null)
            evenList = sort(evenList);

        while(oddList != null && evenList != null){
            if(oddList.getNumber()<evenList.getNumber()){
                darray = removeFront(oddList);
                temp = darray[0];
                oddList = darray[1];
                myNode = insertBack(myNode, temp);
            }
            else{
                darray =removeFront(evenList);
                temp = darray[0];
                evenList = darray[1];
                myNode = insertBack(myNode, temp);
            }
            counter++;
        }

        if(oddList == null)
            myNode = insertBack(myNode, evenList);
        if(evenList == null)
            myNode = insertBack(myNode, oddList);

        return myNode;
        
    }
    
    public LLNode startSort(){
        counter = 0;
        masterList = sort(masterList);
        return masterList;
    }
    
    public void reverseList(){
        LLNode beforeList = masterList;
        LLNode afterList = null;
        LLNode temp;
        
        while (beforeList != null){
            darray = removeFront(beforeList);
            temp = darray[0];
            beforeList = darray[1];
            afterList = insertFront(afterList, temp);
        }
        masterList = afterList;
    }
    
    public int getCount(){
        return counter;
    }
    
}
