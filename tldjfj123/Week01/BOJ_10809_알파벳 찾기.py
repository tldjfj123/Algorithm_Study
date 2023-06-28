import sys
input = sys.stdin.readline

def solution() :
    s = input().rstrip()

    for i in range(97, 123) :
        try :
            print(s.index(chr(i)))
        except :
            print(-1)

solution()