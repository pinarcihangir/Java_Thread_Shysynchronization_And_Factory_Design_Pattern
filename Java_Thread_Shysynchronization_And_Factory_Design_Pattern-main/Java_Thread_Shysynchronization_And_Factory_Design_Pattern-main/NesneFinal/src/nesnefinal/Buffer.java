
package nesnefinal;

import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Buffer {
    
    private int[][] _sonucMatrisi;
    private int row;
    private int column;
    private static final SecureRandom generator = new SecureRandom();
    
    public Buffer(int row, int column){
        _sonucMatrisi = new int[row][column];
        this.row = row;
        this.column = column;
    }
    
    
    public synchronized void Put(int rowPosition,int columnPosition, int value){
        
        try {
            //Dersi izleyerek destek aldığım bölümler. iki boyutlu array mantığına uyguladım
            Thread.sleep(generator.nextInt(500));
        } catch (InterruptedException ex) {
            System.out.println("Interrupted thread!");
        }
        _sonucMatrisi[rowPosition][columnPosition] = value;
        System.out.printf("%s wrote %2d to element indeks of %d%d%n", Thread.currentThread().getName(),value,rowPosition,columnPosition); 
    }
    
    
    public void Print(){
        for(int i=0; i<row;i++){
            for(int k=0;k<column;k++){
                System.out.print(_sonucMatrisi[i][k] + " ");
            }
            System.out.println("\n");
        }
    }
    
}
