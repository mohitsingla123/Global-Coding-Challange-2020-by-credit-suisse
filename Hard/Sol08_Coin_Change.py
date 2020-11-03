def countNumberOfWays(numOfUnits, numOfCoinTypes, coins):
	ways = [0] * (numOfUnits + 1); 

	ways[0] = 1; 

	for i in range(numOfCoinTypes): 

		for j in range(len(ways)): 
			if (coins[i] <= j): 
				ways[j] += ways[(int)(j - coins[i])]; 

	return ways[numOfUnits]; 

def main():
    firstLine = input().split(" ")
    secondLine = input().split(" ")

    numOfUnits = int(firstLine[0])
    numOfCoinTypes = int(firstLine[1])
    coins = list(map(int, secondLine))

    # Participants may update the following function parameters
    answer = countNumberOfWays(numOfUnits, numOfCoinTypes, coins)

    # Please do not remove the below line.
    print(answer)
    # Do not print anything after this line

if __name__ == '__main__':
    main()
