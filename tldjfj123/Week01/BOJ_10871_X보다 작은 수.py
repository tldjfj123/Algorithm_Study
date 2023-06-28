import sys
input = sys.stdin.readline

def solution() :
    n, x = map(int, input().split())
    nums = list(map(int, input().split()))

    for n in nums :
        if n < x :
            print(n, end = ' ')

solution()