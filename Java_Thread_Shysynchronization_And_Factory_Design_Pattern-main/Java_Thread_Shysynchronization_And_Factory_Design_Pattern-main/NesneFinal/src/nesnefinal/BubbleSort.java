package nesnefinal;


public class BubbleSort implements ISort
{
    
    //Parametresiz constructor 
    public BubbleSort() {} 
    
    
    //BubbleSort algoritması
    //Fonksiyonlar implemente edildi
    @Override
    public void Sort(int arr[]) 
    {
        int length = arr.length;     
        int temp = 0;
        for(int i=0; i < length; i++)
        {
            for(int j=1; j < (length-i); j++)
            {
                if(arr[j-1] > arr[j])
                {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    @Override
    public void Sort(int[] arr, int a, int b) {}
}
