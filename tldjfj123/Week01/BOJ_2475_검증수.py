import sys
input = sys.stdin.readline

def solution() :
    nums = list(map(lambda x : x ** 2 , list(map(int, input().split()))))
    print(sum(nums) % 10)

solution()