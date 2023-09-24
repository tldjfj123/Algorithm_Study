import sys
input = sys.stdin.readline

def solution() :
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))

    left = 0
    right = max(arr)
    res = []
    while left <= right :
        mid = (left + right ) // 2

        tmp = 0
        for a in arr :
            if a - mid > 0 :
                tmp += a - mid
        
        if tmp >= m :
            res.append(mid)
            left = mid + 1
        else :
            right = mid - 1
        
    print(max(res))

solution()