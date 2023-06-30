import sys
input = sys.stdin.readline

def solution() :
    while 1 :
        s = input().rstrip()
        if s == '0' :
            break

        if s == s[::-1] :
            print("yes")
        else :
            print("no")
        

solution()