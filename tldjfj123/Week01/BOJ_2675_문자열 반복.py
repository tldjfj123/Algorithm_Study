import sys
input = sys.stdin.readline

def solution() :
    n = int(input())

    for _ in range(n) :
        num, s = input().split()
        res = ''.join(list(map(lambda x : x * int(num), list(s))))
        print(res)

solution()