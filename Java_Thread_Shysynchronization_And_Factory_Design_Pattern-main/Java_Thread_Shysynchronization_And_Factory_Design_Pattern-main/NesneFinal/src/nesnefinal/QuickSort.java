package nesnefinal;
public class QuickSort implements ISort
{
    //Constructor
    public QuickSort() {} 

    
    //Quick Sort için algoritma
    public static int partition(int a[], int beginning, int ending) 
    {

        int left, right, temp, loc, flag;
        loc = left = beginning;
        right = ending;
        flag = 0;
        while(flag != 1)
        {
            while((a[loc] <= a[right]) && (loc!=right))
                right--;
            if(loc==right)
                flag =1;
            else if(a[loc]>a[right])
            {
                temp = a[loc];
                a[loc] = a[right];
                a[right] = temp;
                loc = right;
            }
            if(flag!=1)
            {
                while((a[loc] >= a[left]) && (loc!=left))
                    left++;
                if(loc==left)
                    flag =1;
                else if(a[loc] <a[left])
                {
                    temp = a[loc];
                    a[loc] = a[left];
                    a[left] = temp;
                    loc = left;
                }
            }
        }
        return loc;
    }

    @Override
    public void Sort(int[] array) {} 
    
    @Override
    public void Sort(int array[], int beg, int end) 
    {
        int loc;
        if(beg<end)
        {
            loc = partition(array, beg, end);
            Sort(array, beg, loc-1);
            Sort(array, loc+1, end);
        }
    }
}
