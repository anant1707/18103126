import java.util.*;
public class Solution2 {
    
    public static void counting_sort(int[] arr)
    {
        int[] count = new int[21];
        for(int i: arr)
        count[i]++;

        int index = 0;
        for(int i=0; i<21; ++i)
        {
            int temp=count[i];
            for(int j=0;j<temp;j++)
            {
                arr[index++]=i;
            }
        }
    }
    public static void main(String[] args)
    {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements in array: ");
        n=input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=input.nextInt();
        }
        System.out.print("Original Array: ");
        for(int x:arr)
        System.out.print(x+" ");
        System.out.println();
        counting_sort(arr);
        System.out.print5("Sorted Array: ");
        for(int x:arr)
        System.out.print(x+" ");
    }
}
