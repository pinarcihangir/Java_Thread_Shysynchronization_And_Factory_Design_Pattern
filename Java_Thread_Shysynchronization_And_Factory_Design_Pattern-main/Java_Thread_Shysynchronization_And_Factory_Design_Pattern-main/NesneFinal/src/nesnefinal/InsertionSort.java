package nesnefinal;
public class InsertionSort implements ISort {

    public InsertionSort() {}

    //Sort algoritmasının tam hızını ölçmek için constructor üzerinde değil de metot üzerinde diziyi parametre olarak almayı tercih ettim
    @Override
    public void Sort(int[] arr) { 
        int length = arr.length;
        for (int j = 1; j < length; j++) {
            int key = arr[j];
            int i = j - 1;
            while ((i > -1) && (arr[i] > key)) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }

    @Override
    public void Sort(int[] arr, int a, int b) {}
}
