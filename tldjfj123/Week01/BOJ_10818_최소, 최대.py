import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    nums = list(map(int, input().split()))

    print(f'{min(nums)} {max(nums)}')

solution()