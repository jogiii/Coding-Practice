package other;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int maxDifference(int a, int b) {
        int x=0,y=0;
        if(a%2==0 && a!=2)
            a=a+1;
        if(b%2==0 && b!=2)
            b=b-1;
        for(int i=a;i<=b;i+=2)
        {
            if(isprime(i)==true)
            {
                x=i;
                break;
            }
        }
        for(int i=b;i>=a;i-=2)
        {
            if(isprime(i)==true)
            {
                y=i;
                break;
            }
        }
        if (x==0 && y== 0)
            return -1;
        else
            return y-x;
    }
    public static boolean isprime(int a)
    {
        if(a<=1)
            return false;
        if(a<=3)
            return true;
        if(a%2==0 || a%3==0)
            return false;
        for(int i=5;i*i<=a;i+=6)
        {
            if(a%i==0 || a%(i+2)==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());
        for(int a0 = 0; a0 < q; a0++){
            String str = br.readLine();
            String input[] = str.split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int result = maxDifference(x, y);
            System.out.println(result);
        }
    }
}