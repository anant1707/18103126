import java.util.*;
public class Solution3 
{
    public static void sort(char[]arr)
    {
        int n= arr.length;
        for(int i=0;i<n;i++)
        for(int j=i;j<n;j++)
        {
            if(arr[i]>arr[j])
            {
                char c=arr[i];
                arr[i]=arr[j];
                arr[j]=c;
            }
        }
    }

    public static void main(String[] args) 
    {
        String s;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string to sort: ");
        s=input.nextLine();
        char []arr = s.toCharArray();
        sort(arr);
        System.out.print("Sorted: ");
        for(char c:arr)
        System.out.print(c);
    }
    
}
