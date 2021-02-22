package nesnefinal;
public class AlgorithmFactory implements IAlgorithmFactory
{

    @Override
    public ISort Sorting(SortingTypes type) //DoSorting metodunu implement etim.
    {
        ISort sortAlgorithm = null; //Bu metoda verilen algoritma tirine göre yeni bir algoritma oluştuurlmasını istedim.
        
        
        //Böyle yapmak çok verimli değildi. Ben de enum olarak sorting işlemlerini tutmaya karar verdim. Böylece genişletilmeye daha müsait bir kod oldu
        /*
        if(type.getClass().getName().equals("BubbleSort")){
            sortAlgorithm = new BubbleSort();
        }
        else if(type.getClass().getName().equals("QuickSort")){
            sortAlgorithm = new QuickSort();
        }
        else if(type.getClass().getName().equals("InsertionSort")){
            sortAlgorithm = new InsertionSort();
        }
        else{
            System.out.println("Sorting algoritması yanlış girildi.");
        }
        */ 
        switch (type){
            case BubbleSort:
                sortAlgorithm = new BubbleSort();
                break;
            case QuickSort:
                sortAlgorithm = new QuickSort();
                break;
            case InsertionSort:
                sortAlgorithm = new InsertionSort();
                break;
        }
        return sortAlgorithm;
    }


}