package nesnefinal;

//Sortingler için bir çatı oluşturdum
public interface ISort {  

    //BubbleSort ve InsertionSort için array göndermek yeterli
    void Sort(int[] dizi); 
    
    //QuickSort algoritması için başlangıç ve bitiş indexleri girilmelidir
    void Sort(int[] dizi, int baslagic, int bitis);  
}

