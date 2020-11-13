import math
import os
import random
import re
import sys

# Complete the candies function below.
def candies(n, arr):
    res = [1] * len(arr)
    
    # left->right, top->down
    for i in range(1, len(arr)):
        if arr[i] > arr[i-1]:
            res[i] = res[i-1] + 1
            
    # right to left, down->top
    for i in range(len(arr)-1, 0, -1):
        if (arr[i-1] > arr[i]) and (res[i-1] <= res[i]):
            res[i-1] = res[i] + 1
            
    return sum(res)
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = []

    for _ in range(n):
        arr_item = int(input())
        arr.append(arr_item)

    result = candies(n, arr)

    fptr.write(str(result) + '\n')

    fptr.close()
