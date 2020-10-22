// Solution: All 90 test case passed.
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Solution {

    public static double maximumExpectedMoney(int n, int m, double[] p, double[] x, double[] y)  {
        double[] arr = new double[n];
        for(int i = 0 ; i < n ; i++)
        {
            
            arr[i] = (p[i] * x[i]) - ((1-p[i]) * y[i]);
            
            //System.out.println(arr[i]);
        }
        
        Arrays.sort(arr);
        double max = 0;
        int k = n-1;
        for(int j = 0; j<m;j++)
        {
            if(arr[k]>0)
            {
            max = max + arr[k];
            }
            k--;
        }
        max = Math.round(max * 100.0)/100.0 ;
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException  {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        double[] p = new double[n];
        double[] x = new double[n];
        double[] y = new double[n];
        double result = 0;

        //get input
        for(int i = 0; i < n; i++)
            p[i] = in.nextDouble();
        for(int i = 0; i < n; i++)
            x[i] = in.nextDouble();
        for(int i = 0; i < n; i++)
            y[i] = in.nextDouble();

        result = maximumExpectedMoney(n,m,p,x,y);

        // Do not remove below line
        System.out.println(result);
        // Do not print anything after this line

        in.close();
    }
}
