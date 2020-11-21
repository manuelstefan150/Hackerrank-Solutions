import math
import os
import random
import re
import sys

output = dict()
output[1] = 1 
output[2] = 2 
output[3] = 4

def stepPerms(n):
    if n==0:
        return 0
    if n in output.keys():
        return output[n]
    output[n] = stepPerms(n-1) + stepPerms(n-2) + stepPerms(n-3)
    return output[n]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = int(input())

    for s_itr in range(s):
        n = int(input())

        res = stepPerms(n)

        fptr.write(str(res) + '\n')

    fptr.close()
