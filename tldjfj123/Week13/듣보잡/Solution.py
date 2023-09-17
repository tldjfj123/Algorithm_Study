import sys
input = sys.stdin.readline

def solution() :
    n, m = map(int, input().split())
    d = []
    b = []

    for _ in range(n) :
        d.append(input().rstrip())

    for _ in range(m) :
        b.append(input().rstrip())
    
    db = sorted(list(set(d) & set(b)))

    print(len(db))
    for factor in db :
        print(factor)

solution()