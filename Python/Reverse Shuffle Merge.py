#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the reverseShuffleMerge function below.
def reverseShuffleMerge(s):
    from collections import Counter
    char_freq = Counter(s)
    used = Counter()
    remaining = Counter(s)
    
    res = []
    
    def use(char):
        return char_freq[char]//2 > used[char]
    
    def pop(char):
        return used[char] + remaining[char] - 1 >= char_freq[char]//2
    
    for char in reversed(s):
        if use(char):
            while res and res[-1] > char and pop(res[-1]):
                removed_char = res.pop()
                used[removed_char] -= 1
            res.append(char)
            used[char] += 1
        remaining[char] -= 1
    return "".join(res)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = reverseShuffleMerge(s)

    fptr.write(result + '\n')

    fptr.close()
