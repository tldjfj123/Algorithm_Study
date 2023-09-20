import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    times = [list(map(int, input().split())) for _ in range(n)]

    times.sort(key = lambda x : (x[1], -abs(x[1] - x[0])))
    res = []
    for t in times :
        if not res :
            res.append(t)
        else :
            if res[-1][1] <= t[0] :
                res.append(t)
    print(len(res))

solution()