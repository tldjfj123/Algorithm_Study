import sys
input = sys.stdin.readline

def solution() :
    n = input().rstrip()

    for i in range(1, 1000001) :
        part = i + sum(list(map(int, list(str(i)))))
        
        if part == int(n) :
            print(i)
            break
    else :
        print(0)

solution()