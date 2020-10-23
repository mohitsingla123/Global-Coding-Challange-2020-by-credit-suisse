// Solution: All test cases passed
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Solution {

    // You may change this function parameters
    static int findMaxProfit(int numOfPredictedTimes, int[] predictedSharePrices) {
        int k = numOfPredictedTimes/2 ;
        int[][] profit = new int[k+1][numOfPredictedTimes+1]; 


		for (int i = 0; i <= k; i++) 
			profit[i][0] = 0; 

		for (int j = 0; j <= numOfPredictedTimes; j++) 
			profit[0][j] = 0; 

		for (int i = 1; i <= k; i++) 
		{ 
			for (int j = 1; j < numOfPredictedTimes; j++) 
			{ 
				int max_so_far = 0; 

				for (int m = 0; m < j; m++) 
				max_so_far = Math.max(max_so_far, predictedSharePrices[j] - 
							predictedSharePrices[m] + profit[i - 1][m]); 

				profit[i][j] = Math.max(profit[i] [j - 1], 
											max_so_far); 
			} 
		} 

		return profit[k][numOfPredictedTimes - 1];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] firstLine = scanner.nextLine().split(" ");
        int[] firstLineArr = Stream.of(firstLine).mapToInt(Integer::parseInt).toArray();
        int numOfPredictedTimes = firstLineArr[0];
        int[] predictedSharePrices = Arrays.copyOfRange(firstLineArr, 1, firstLineArr.length);
        scanner.close();

        int result = findMaxProfit(numOfPredictedTimes, predictedSharePrices);
        // Please do not remove the below line.
        System.out.println(result);
        // Do not print anything after this line
    }
}
