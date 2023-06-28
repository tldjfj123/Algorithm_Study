import sys
input = sys.stdin.readline

def solution() :
    while 1 :
        try :
            a, b = map(int, input().split())
            print(a + b)
        except :
            break

solution()