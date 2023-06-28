import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    for _ in range(n) :
        a, b = map(int, input().split())
        print(a + b)

solution()