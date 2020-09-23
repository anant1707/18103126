import java.util.*;
public class Solution5
{
    public static void main(String []args)
    {
        Scanner input = new Scanner(System.in);
        int []universal = new int[11];
        
        int A_size,B_size,A[],B[];
        //enter the size of setA
        System.out.print("Enter the size of set A: ");
        A_size = input.nextInt();
        A = new int[A_size];

        //input the setA
        for(int i=0;i<A_size;i++)
        {
            A[i] = input.nextInt();
        }

        //enter the size of setB
        System.out.print("Enter the size of set B: ");
        B_size = input.nextInt();
        B = new int[A_size];

        //input the setA
        for(int i=0;i<B_size;i++)
        {
            B[i] = input.nextInt();
        }

        for(int i:A)
        universal[i]=1;
        for(int i:B)
        universal[i]+=2;

        //A Union B -----A Intersection B
               
        ArrayList<Integer>union = new ArrayList<Integer>();
        ArrayList<Integer>intersection =  new ArrayList<Integer>();
        ArrayList<Integer>Acompliment = new ArrayList<Integer>();
        ArrayList<Integer>Bcompliment = new ArrayList<Integer>();
        for(int i=0;i<11;i++)
        {
            if(universal[i]!=0)
            {
                union.add(i);
            }
            if(universal[i]==3)
            {
                intersection.add(i);
            }
            if(universal[i]==2 || universal[i]==0)
            {
                Acompliment.add(i);
            }
            if(universal[i]==1 || universal[i]==0)
            {
                Bcompliment.add(i);
            }
        }

        System.out.println("A UNION B: "+union);
        System.out.println("A INTERSECTION B: "+intersection);
        System.out.println("A Compliment: "+Acompliment);
        System.out.println("B Compliment: "+Bcompliment);








    }
}