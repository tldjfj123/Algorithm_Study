import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    print(sum(list(map(int, list(input().rstrip())))))

solution()