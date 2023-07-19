import sys
input = sys.stdin.readline

def solution() :
    n = int(input())

    nums = [int(input()) for _ in range(n)]

    for p in sorted(nums) :
        print(p)

solution()