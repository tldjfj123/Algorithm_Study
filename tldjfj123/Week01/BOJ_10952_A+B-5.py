import sys
input = sys.stdin.readline

def solution() :
    while 1 :
        a , b = map(int, input().split())
        if a + b == 0 :
            break
        else :
            print(a+b)

solution()