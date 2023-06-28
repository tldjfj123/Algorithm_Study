import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    for i in range(n-1, -1, -1) :
        print(' ' * i, end = '')
        print('*' * (n - i))

solution()