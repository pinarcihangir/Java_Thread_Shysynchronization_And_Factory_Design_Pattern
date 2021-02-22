
package nesnefinal;

import java.util.concurrent.*;
public class Soru1Deneme {
    
    
    public static void main(String[] args) {
        MatrisOku matrisOku1 = new MatrisOku("Matris1.txt");
        int[][] matris1 = matrisOku1.MatrisDondur();
        
        MatrisOku matrisOku2 = new MatrisOku("Matris2.txt");
        int[][] matris2 = matrisOku2.MatrisDondur();
        
        //System.out.println("matris2  = "+matris2[2][0]+matris2[2][1]);
        if(matris1[0].length != matris2.length){
            System.out.println("Bu matris'ler birbiriyle çarpılamaz. Lütfen çarpılabilir matrisler giriniz.");
            System.exit(0);
        }
        
        Buffer buffer = new Buffer(matris1.length, matris2[0].length); //Sonuç matrisi ilk matrisin row'u kadar ve ikinci matrisin column'u kadar olur
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        for(int i=0;i<matris1.length;i++){
            int[] satir = matris1[i];
            //System.out.println("satir = "+satir[0]+satir[1]+satir[2]);
            MultiplyWorker thread = new MultiplyWorker(satir, matris2, i, buffer);
            executorService.execute(thread);
                     
        }
        
        executorService.shutdown();
        
        try{
            boolean tasksEnded = executorService.awaitTermination(15, TimeUnit.SECONDS);
            
            if(tasksEnded){
                System.out.println("Contents (Sonuc Matrisi) : ");
                buffer.Print();
            }
            else System.out.println("Timed out while waiting");
        }
        catch(InterruptedException ex){
             ex.printStackTrace();
        }
    }
    
    
}
