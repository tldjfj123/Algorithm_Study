import sys
input = sys.stdin.readline

def solution() :
    arr = list(map(int, input().split()))

    if arr == sorted(arr, reverse=True) :
        print('descending')
    elif arr == sorted(arr) :
        print('ascending')
    else :
        print('mixed')

solution()