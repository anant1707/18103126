public class Solution4{
    public static void main(String[] args){
        int n=1,res;
        long sum;
        while(n<Integer.MAX_VALUE)
        {
            sum=((n)*(n+1))/2;
            if(sum==n*n){
                res=n;
            }
            n++;
        }
        System.out.println("The value is: "+n);
    }
}