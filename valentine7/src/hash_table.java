
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import jxl.read.biff.BiffException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 * class SLLode to form node of linked list.
 * @author ARPITA  AYUSHI
 */
   	class SLLNode
   	{
   	    SLLNode next;
   	    String boy;
            String girl;
   	    /* Constructor */
   	    public SLLNode(String b, String g)
   	    {
   	        boy = b;
                girl = g;
  	        next = null;
    	    }
    	}
    	 
    	/* Class HashTableChainingSinglyLinkedList */
/**
 * class HashTableChainingSinglyLinkedList is for various implementation of linked list and hash table
 * @author ARPITA  AYUSHI
 */
    	class HashTableChainingSinglyLinkedList
    	{
    	    private SLLNode[] table;
    	    private int size ;
    	 
  	    /* Constructor */
    	    public HashTableChainingSinglyLinkedList(int tableSize)
    	    {
    	        table = new SLLNode[ nextPrime(tableSize) ];
    	        size = 0;
    	    }
    	    /* Function to check if hash table is empty */
    	    public boolean isEmpty()
    	    {
    	        return size == 0;
  	    }
    	    /* Function to clear hash table */
    	    public void makeEmpty()
    	    {
    	        int l = table.length;
    	        table = new SLLNode[l];
    	        size = 0;
    	    }
    	    /* Function to get size */
    	    public int getSize()
  	    {
    	        return size;
    	    }
    	    /* Function to insert an element */
    	    public void insert(String b, String g)
    	    {
    	        size++;
    	        int pos = myhash(b);        
    	        SLLNode nptr = new SLLNode(b,g);                
    	        if (table[pos] == null)
  	            table[pos] = nptr;            
    	        else
    	        {
    	            nptr.next = table[pos];
    	            table[pos] = nptr;
    	        }    
    	    }
    	    /* Function to remove an element */
    	    public void remove(String val)
    	    {
  	        int pos = myhash(val);    
    	        SLLNode start = table[pos];
    	        SLLNode end = start;
    	        if (start.boy == val)
    	        {
    	            size--;
    	            table[pos] = start.next;
    	            return;
    	        }
    	        while (end.next != null && end.next.boy != val)
  	            end = end.next;
    	        if (end.next == null)
    	        {
    	            System.out.println("\nElement not found\n");
    	            return;
    	        }
    	        size--;
    	        if (end.next.next == null)
    	        {
    	            end.next = null;
  	            return;
    	        }
    	        end.next = end.next.next;
  	        table[pos] = start;
    	    }
    	    /* Function myhash */
    	    private int myhash(String x )
    	    {
    	        int hashVal = x.hashCode();
    	        hashVal %= table.length;
  	        if (hashVal < 0)
    	            hashVal += table.length;
    	        return hashVal;
    	    }
    	    /* Function to generate next prime number >= n */
    	    private static int nextPrime( int n )
    	    {
    	        if (n % 2 == 0)
    	            n++;
    	        for ( ; !isPrime( n ); n += 2);
    	 
   	        return n;
   	    }
   	    /* Function to check if given number is prime */
   	    private static boolean isPrime( int n )
   	    {
   	        if (n == 2 || n == 3)
   	            return true;
   	        if (n ==  1 || n % 2 == 0)
   	            return false;
   	        for (int i = 3; i * i <= n; i += 2)
     	            if (n % i == 0)
     	                return false;
     	        return true;
     	    }
     	    public void printHashTable ()
     	    {
     	        System.out.println();
     	        for (int i = 0; i < table.length; i++)
     	        {
   	            System.out.print ("Bucket " + i + ":  ");             
     	            SLLNode start = table[i];
     	            while(start != null)
     	            {
     	                System.out.print(start.boy +" ");
     	                start = start.next;
     	            }
   	            System.out.println();
     	        }
     	    }   
            public int found (String boys)
     	    {
     	        //System.out.println();
                
     	        for (int i = 0; i < table.length; i++)
     	        {
   	           // System.out.print ("Bucket " + i + ":  ");             
     	            SLLNode start = table[i];
     	            while(start != null)
     	            {
     	               // System.out.print(start.boy +" ");
                        if(start.boy.equals(boys)){
                             System.out.println("girl = "+start.girl);
                            return 1;
                        }
     	                start = start.next;
     	            }
   	           // System.out.println();
     	        }
                return 0;
     	    }   
   	}
    	 

/*class array{
    String boy;
    String girl;
    public array(String boy, String girl){
        this.boy = boy;
        this.girl = girl;
    }
}*/

/**
 * it is hash table implementation to find girlfriends.
 * it inherits the class anonymous_method.
 * Implement all variants via inheritance and use upcasting to the base class
 * @author ARPITA AYUSHI
 */
public class hash_table extends anonymous_method{
    /**
     * for hash table implementation.
     */
    public void hash(){
        JFileChooser jChooser = new JFileChooser();
        String doc = (jChooser.getFileSystemView().getDefaultDirectory().toString());
        try {
            workbook2 = jxl.Workbook.getWorkbook(new File(doc + "\\couples.xls"));
        } catch (IOException ex) {
            Logger.getLogger(linked_list.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(linked_list.class.getName()).log(Level.SEVERE, null, ex);
        }
        jxl.Sheet sheet1 = workbook2.getSheet(0);
        jxl.Cell cell,cell1;
        arr = new String[sheet1.getRows()-1][2];
        int i;
         htcsll = new HashTableChainingSinglyLinkedList(10);
        for(i=1;i<sheet1.getRows();i++){
            cell = sheet1.getCell(1, i);
            cell1 = sheet1.getCell(0, i);
            htcsll.insert(cell.getContents(), cell1.getContents());
        }
        
    }
    /**
     * to store the information of girlfriends of various boys.
     * @param r is object of class random which contain the list of boys.
     */
    @Override
    public void couple(random r) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        hash();
        int found = 0;
        for(int i=0;i<r.boys.size();i++){
            found = 0;
            System.out.print("boy = "+r.boys.elementAt(i)+"  ");
            /*for(int j =0;j<arr.length;j++){
                if(arr[j][0].equals(r.boys.elementAt(i))){
                    System.out.println("girl = "+arr[j][1]);
                    found = 1;
                    break;
                }
            }*/
            found  = htcsll.found((String) r.boys.elementAt(i));
            if(found==0){
                System.out.println("girl = NOT COUPLE");
            }
        }
    }
    
    private jxl.Workbook workbook2;
    public String[][] arr;
    public HashTableChainingSinglyLinkedList htcsll;
}
