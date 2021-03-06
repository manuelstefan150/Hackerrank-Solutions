import math
import os
import random
import re
import sys

def gradingStudents(grades):
    res = []
    for grade in grades:
        diff = 5 - grade % 5
        if grade >= 38 and diff < 3:
            grade += diff
        res.append(grade)
    return res

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    grades_count = int(input().strip())

    grades = []

    for _ in range(grades_count):
        grades_item = int(input().strip())
        grades.append(grades_item)

    result = gradingStudents(grades)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
