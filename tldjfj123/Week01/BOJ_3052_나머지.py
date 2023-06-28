import sys
input = sys.stdin.readline

def solution() :
    res = dict()
    for _ in range(10) :
        n = int(input())
        if n % 42 not in res.keys() :
            res[n % 42] = 1
        else :
            res[n % 42] += 1

    print(len(res.keys()))

solution()