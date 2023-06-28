import sys
input = sys.stdin.readline

def solution() :
    arr = [int(input()) for _ in range(9)]
    print(max(arr))
    print(arr.index(max(arr))+1)


solution()