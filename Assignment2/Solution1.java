import java.util.*;
class Solution1
{
    public static int Compare(String first,String second)
    {
        for(int i=0;i<Math.min(first.length(),second.length());i++)
        {
            if(first.charAt(i)>second.charAt(i))
            {
                return 1;
            }
            else if(first.charAt(i)<second.charAt(i))
            {
                return 2;
            }
        }
        if(first.length()==second.length())
            return 3;
        else
        {
            if(first.length()>second.length())
                return 1;
            else
                return 2;
        }
    }
    public static void main(String []args)
    {
        String first,second;
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the first string: ");
        first=input.nextLine();
        System.out.print("Enter the second string: ");
        second=input.nextLine();
        int result = Compare(first,second);

        if(result==1)
        {
            System.out.println("First String is Lexicographically Greater");
        }
        else if(result==2)
        {
            System.out.println("Second String is Lexicograpically Greater");
        }
        else
        {
            System.out.println("Both the Strings are equal");
        }


    }
}