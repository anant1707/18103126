import java.util.*;
public class Solution2{
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the paragraph:");
        String paragraph=input.nextLine();
        System.out.println("Enter the words to markout seperated by space:");
        String markout_words=input.nextLine();
        ArrayList<String>words=new ArrayList<String>();
        StringBuilder temp=new StringBuilder();
        int n=markout_words.length();
        int i=0;
        while(i<n)
        {
            if(markout_words.charAt(i)==' ')
            {
            String tempstr=temp.toString();
            words.add(tempstr);
            temp=new StringBuilder();
            }
            else
            temp.append(markout_words.charAt(i));
            i++;
        }
        String tempstr=temp.toString();
        words.add(tempstr);
        StringBuilder substitute;
        for(String x:words)
        {
            substitute = new StringBuilder();
            substitute.append(x.charAt(0));
            for(i=0; i<x.length()-1; ++i)
                substitute.append('*');
            x="\\b"+x+"\\b";
            paragraph=paragraph.replaceAll(x, substitute.toString());
        }
        System.out.println(paragraph);
    }
}