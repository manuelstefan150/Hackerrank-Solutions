from collections import Counter

m, n = map(int, input().split())

mag = Counter(input().split())
note = Counter(input().split())

result = note - mag

if result == {}:
    print("Yes")
else:
    print("No")
