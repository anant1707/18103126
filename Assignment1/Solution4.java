import java.util.*;
public class Solution4
{
    private static String sortString(String inputString) { 
        char tempArray[] = inputString.toCharArray(); 
        Arrays.sort(tempArray); 
        return new String(tempArray); 
    } 
    private static boolean isAnagram(String pattern,String temp) {
        
        pattern=sortString(pattern);
        temp=sortString(temp);
        for(int i=0;i<pattern.length();i++)
        {
            if(pattern.charAt(i)!=temp.charAt(i))
            return false;
        }
        return true;
    }
    public static void main(String []args)
    {
        Scanner input=new Scanner(System.in);
        String str1,str2;
        boolean result;
        str1=input.nextLine();
        str2=input.nextLine();
        result=isAnagram(str1,str2);
        if(result)
        System.out.println("The given strings are Anagrams");
        else
        System.out.println("The given strings are not Anagrams");
    }
}