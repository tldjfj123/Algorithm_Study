import sys
input = sys.stdin.readline

def solution() :
    n = int(input())

    for i in range(1, 10) :
        print(f'{n} * {i} = {n * i}')

solution()