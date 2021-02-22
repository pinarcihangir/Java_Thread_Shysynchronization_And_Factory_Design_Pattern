package nesnefinal;
public enum SortingTypes 
//Her algoritma için integer değerler belirlendi ve seçilen algoritma döndürüldü
{                    
    BubbleSort(0),
    QuickSort(1),
    InsertionSort(2);

    int sort;
    SortingTypes(int sort){
        this.sort = sort;
    }

    public int getSort(){
        return sort;
    }
}
