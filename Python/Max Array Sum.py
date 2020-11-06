import math
import os
import random
import re
import sys

# Complete the maxSubsetSum function below.
def maxSubsetSum(arr):
    x = [0 for _ in range(n)]
    x[0] = arr[0]
    x[1] = max(arr[0], arr[1])
    
    for index in range(2, n):
        x[index] = max(arr[index], arr[index] + x[index-2], x[index-1])
    return x[-1]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    res = maxSubsetSum(arr)

    fptr.write(str(res) + '\n')

    fptr.close()
