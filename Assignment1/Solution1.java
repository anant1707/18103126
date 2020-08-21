import java.util.*;
public class Solution1{
    public static String sortString(String inputString) { 
        char tempArray[] = inputString.toCharArray(); 
        Arrays.sort(tempArray); 
        return new String(tempArray); 
    } 
    public static boolean isAnagram(String pattern,String temp) {
        
        pattern=sortString(pattern);
        temp=sortString(temp);
        for(int i=0;i<pattern.length();i++)
        {
            if(pattern.charAt(i)!=temp.charAt(i))
            return false;
        }
        return true;
    }
    public static void main(String []args) {
        Scanner input=new Scanner(System.in);
        String pattern,text;
        System.out.println("Enter the Text:");
        text=input.nextLine();
        System.out.println("Enter the Pattern to be Matched:");
        pattern=input.nextLine();

        int pattern_hash=0,current_hash=0;
        int start=0,end=(pattern.length()-1);
        for(int i=0;i<pattern.length();i++){
            pattern_hash+=((int)pattern.charAt(i));
            if(i<=end)
            current_hash+=((int)text.charAt(i));
        }
        int n=text.length();
        int count=0;
        while(end<n-1){
            //System.out.println(current_hash+" "+pattern_hash);
            if(current_hash==pattern_hash)
            {
                if(isAnagram(pattern,text.substring(start,end+1)))
                    count++;
            }
            current_hash-=((int)text.charAt(start));
            current_hash+=((int)text.charAt(end+1));
            start++;
            end++;
        }
        if(current_hash==pattern_hash){
                if(isAnagram(pattern,text.substring(start,end+1)))
                    count++;
            }
        System.out.println(count);
    }
}