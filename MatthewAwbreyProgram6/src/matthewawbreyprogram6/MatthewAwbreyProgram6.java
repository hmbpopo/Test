/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matthewawbreyprogram6;

import java.util.Random;

/**
 *
 * @author Matt
 */
public class MatthewAwbreyProgram6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random rnd = new Random();
        int maxSize = 5000;
        int[] randomSort = new int[20];
        int[] inOrderSort = new int[20];
        int[] revSort = new int[20];
        int randomAverage = 0;
        int inOrderAverage = 0;
        int revAverage = 0;
        
        // create loop for 20 runs
        for(int j = 0; j < 20; j++){
            LLNode myList = new LLNode();

            // create and populate List
            myList.setNumber(rnd.nextInt(10000));

            MergeSortLL mSort = new MergeSortLL(myList);

            for(int i = 0; i < maxSize-1; i++){
                int temp = rnd.nextInt(10000);
                LLNode node = new LLNode();
                node.setNumber(temp);
                mSort.insertBack(myList, node);
            }

            //random sort
            //System.out.print("Random Sort: ");
            mSort.startSort();
            randomSort[j] = mSort.getCount();
            randomAverage += mSort.getCount();
            //System.out.println(mSort.getCount());

            //in order sort
            //System.out.print("In Order Sort: ");
            mSort.startSort();
            inOrderSort[j] = mSort.getCount();
            inOrderAverage += mSort.getCount();
            //System.out.println(mSort.getCount());

            //reverse sorted sort
            //System.out.print("Reverse Order Sort: ");
            mSort.reverseList();
            mSort.startSort();
            revSort[j] = mSort.getCount();
            revAverage += mSort.getCount();
            //System.out.println(mSort.getCount());

        }
        
        //print random
        System.out.println("Sorting a Random Linked List:");
        System.out.println("------------------------------");
        for(int k = 0; k < 20; k++)
            System.out.println("    Run #" + (k+1) + ": " + randomSort[k]);
        System.out.println("Average run length: " + randomAverage/20);
        
        //print in order
        System.out.println("\nSorting an In Order Linked List:");
        System.out.println("---------------------------------");
        for(int k = 0; k < 20; k++)
            System.out.println("    Run #" + (k+1) + ": " + inOrderSort[k]);
        System.out.println("Average run length: " + inOrderAverage/20);
        
        //print reverse order
        System.out.println("\nSorting a reverse order Linked List:");
        System.out.println("-------------------------------------");
        for(int k = 0; k < 20; k++)
            System.out.println("    Run #" + (k+1) + ": " + revSort[k]);
        System.out.println("Average run length: " + revAverage/20);
        
        
        
    }
}
