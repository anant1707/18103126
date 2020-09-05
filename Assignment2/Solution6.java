import java.util.*;
public class Solution6{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number: ");
        int n = input.nextInt();

        while(n!=1 && n<=Integer.MAX_VALUE && n>0)
        {
            System.out.print(n+" ");
            if(n%2==0)
            {
                n/=2;
            }
            else
            {
                n*=3;
                n+=1;
            }
        }
        
        if(n==Integer.MAX_VALUE || n<0)
        System.out.println("OVERFLOW");
        else
        System.out.println(1);
    }
}