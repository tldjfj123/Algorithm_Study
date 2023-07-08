import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    words = list(input().rstrip())

    res = 0
    for i in range(n) :
        res += (ord(words[i])-96) * (31 ** i) 
    
    print(res % 1234567891)

solution()