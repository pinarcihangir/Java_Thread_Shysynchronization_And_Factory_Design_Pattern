package nesnefinal;

import java.util.concurrent.ThreadLocalRandom;

public class Soru2Deneme
{
    
    public static void main(String args[])
    {
        DiziYazdir diziYazdir = new DiziYazdir();
        int[] dizi = new int[12];
        
        //Rastgele sayılar ürettim. İzlemesi kolay olsun diye dizinin eleman sayısını çok fazla tutmadım. İstenirse kolaylıkla arttırılabilir
        for(int i=0;i<dizi.length;i++){
            dizi[i] = ThreadLocalRandom.current().nextInt(-50, 150 + 1);
        }
        
        System.out.println("Randomize oluşmuş dizinin ilk hali:");
        diziYazdir.Yazdir(dizi);
        
        
        //Sıralama algoritmalarını göndereceğimiz Factory nesnesini oluşturdum
        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        
        //BubbleSort işlemi için başlangıç zamanı.
        long startTime = 0; 
        //BubbleSort işlemi için bitiş zamanı.
        long endTime = 0;
        
        //Sistemden zaman tekrar alınıyor
        startTime = System.currentTimeMillis(); 
        //BubbleSort için interface üzerinden ve SortingTypes üzerinden  giderek
        ISort bubbleSort = algorithmFactory.Sorting(SortingTypes.BubbleSort); 
        
        //Sort edildi
        bubbleSort.Sort(dizi); 
        System.out.println("BubbleSort ile sıralandıktan sonra: ");
        diziYazdir.Yazdir(dizi);

        endTime = System.currentTimeMillis();
        //Aradaki fark çalışma süresi olmuş oldu
        System.out.printf("BubbleSort Çalışma Süresi %4f: \n", ((double) (endTime - startTime)) / 1000); 

        startTime = 0; 
        endTime = 0;
        startTime = System.currentTimeMillis(); 

        //Aynı işlemleri QuickSort için tekrarlıyorum
        ISort quickSort = algorithmFactory.Sorting(SortingTypes.QuickSort); 
        quickSort.Sort(dizi,0,9); 
        System.out.println("QuickSort ile sıralandıktan sonra: ");
        diziYazdir.Yazdir(dizi);

        endTime = System.currentTimeMillis();  
        System.out.printf("QuickSort Çalışma Süresi : %4f \n" ,((double) (endTime - startTime)) / 1000); 

        startTime = 0; 
        endTime = 0;
        startTime = System.currentTimeMillis(); 

        //InsertionSort için aynı işlemler tekrar edildi
        ISort insertionSort = algorithmFactory.Sorting(SortingTypes.InsertionSort); 
        insertionSort.Sort(dizi); 
        System.out.println("InsertionSort ile sıralandıktan sonra: ");
        diziYazdir.Yazdir(dizi);

        endTime = System.currentTimeMillis();  
        System.out.printf("InsertionSort Çalışma Süresi : %4f\n" ,((double) (endTime - startTime)) / 1000); 
    }
    

}
