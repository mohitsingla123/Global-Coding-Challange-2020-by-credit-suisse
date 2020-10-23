// Solution: 74/90 test cases passed.
import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            String answer ="";
            int[] values = new int[n];
            int[] profit = new int[d];
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextInt();
            }

            for (int j = 0; j < d; j++) {
                profit[j] = scanner.nextInt();
            }
            answer = findMinDays(values,profit);
            System.out.println(answer);
        }
    }

    public static String findMinDays(int[] values, int[] profit) {

        int len = profit.length;
        int len2 = values.length ;
        String s = "";
        for(int i = 0; i< len; i++)
        {
            int days = len2+1;
            int temp1=-1;
            int temp2=-1;
            int val = profit[i];
            System.out.println("");
            for(int j = 0; j<len2-1; j++)
            {

                for(int k = i+1; k<len2 ;k++)
                {
                    int local = values[k] - values[j];
                    if (local == val )
                    {
                        if(temp2<= j+1 && temp2 != -1)
                        {
                            continue;
                        }
                        else if((k-j)<days)
                        {
                        temp1 = j+1;
                        temp2 = k+1;
                        days = k-j ;
                        //System.out.println("temp1 "+temp1+" temp2 "+temp2+" days "+ days + " local  "+ local+ " val "+val);
                        }
                    }
                }
            }
            if (s.isEmpty() == true)
            {
                if (temp1 == -1)
                {
                    s = "-1";
                }
                else
                s = temp1+" "+temp2;
            }
            else if (temp1 == -1)
            {
                s = s + ",-1";
            }
            else
            {
                s = s + ","+temp1 +" "+temp2;
            }
        }

        return s;

    }
}
