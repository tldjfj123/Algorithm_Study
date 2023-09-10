import sys
input = sys.stdin.readline

def solution() :
    n, m = map(int, input().split())
    namedogam = dict()
    numdogam = dict()

    idx = 1
    for _ in range(n) :
        s = input().rstrip()
        namedogam[s] = idx
        numdogam[idx] = s
        idx += 1
    
    for _ in range(m) :
        q = input().rstrip()
        if q.isdigit() :
            print(numdogam[int(q)])
        else :
            print(namedogam[q])

solution()