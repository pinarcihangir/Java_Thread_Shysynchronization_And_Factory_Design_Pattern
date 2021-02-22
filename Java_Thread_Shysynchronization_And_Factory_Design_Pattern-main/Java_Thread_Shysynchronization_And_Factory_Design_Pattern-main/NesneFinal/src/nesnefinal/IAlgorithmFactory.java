package nesnefinal;
public interface IAlgorithmFactory
{
    
    //Yapılacak olan sort işleminde hangi algoritmanın kullanılacağını belirledim.
    //söylediğimiz DoSorting fonksiyonunu tanımladım.
    
    ISort Sorting(SortingTypes sortingType); 
}
