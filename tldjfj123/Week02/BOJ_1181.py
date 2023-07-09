import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    words = list(set([input().rstrip() for _ in range(n)]))

    words.sort(key = lambda x : (len(x), x))

    for w in words :
        print(w)

solution()