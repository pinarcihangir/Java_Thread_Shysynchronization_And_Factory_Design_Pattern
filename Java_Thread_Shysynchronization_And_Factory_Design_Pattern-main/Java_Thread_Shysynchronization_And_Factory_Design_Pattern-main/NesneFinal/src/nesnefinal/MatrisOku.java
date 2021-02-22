package nesnefinal;

import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.logging.Level;
import java.util.logging.Logger;


//Text dosyasında bulunan matrisi okuyan ve bunu 2 dimensional array şeklinde döndüren metot.
//Öncesinde text içindeki matrisin satır ve sütun sayısını bulduğu için istenilen büyüklükte bir matris okunabilir

public class MatrisOku {
    
    private File myObj;
    private Scanner myReader;
    private int[][] matris;
    private int satirSayisi;
    private int sutunSayisi;
    
    public MatrisOku(String path){
        myObj = new File(path);
        satirSayisi=0;
        sutunSayisi=0;
        try { //matris'in satır sütun sayısını bulabilmek için dosya bir kez okunur. Böylece kullanıcı istediği büyüklükte matrisler'i çarpabilir.
            myReader = new Scanner(myObj);
            int sayac =0; // sütun sayısının sadece bir kez bulunması yeterli. her satır için bu sayıyı arttırmak hata sebebi olurdu
            while(myReader.hasNextLine()){
                Scanner colReader = new Scanner(myReader.nextLine());
                
                    while(colReader.hasNextInt() && sayac==0){
                        int s = colReader.nextInt();
                        sutunSayisi++;
                        
                    }
                sayac++;
                satirSayisi++;
            }
            
            myReader.close(); //Scanner kapatıldı. Kapatılmazsa dosya  tekrar okunurken yeni satır bulamaz. Hata verir.
            
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya okunurken hata meydana geldi");
        }
        matris = new int[satirSayisi][sutunSayisi];
        
        try {
            Scanner scanner = new Scanner(myObj);
            int satirIndex =0;
            int sutunIndex =0;
            while(scanner.hasNextLine()){
                Scanner colReader = new Scanner(scanner.nextLine());
                while(colReader.hasNextInt()){
                    int sayi = colReader.nextInt();
                    matris[satirIndex][sutunIndex]= sayi;
                    sutunIndex++;
                }
                satirIndex++;
                sutunIndex=0;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya okunurken hata meydana geldi");
        }
    }
    
    public int[][] MatrisDondur(){
        return matris;
    }
    
    public int MatrisSatirSayisi(){
        return satirSayisi;
    }
    
    public int MatrisSutunSayisi(){
        return sutunSayisi;
    }
}
