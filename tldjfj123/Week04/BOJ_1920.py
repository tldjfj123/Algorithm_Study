import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    std = sorted(list(map(int, input().split())))

    m = int(input())
    nums = list(map(int, input().split()))

    for target in nums :
        left = 0
        right = n-1
        flag = False

        while left <= right :
            mid = (left + right) // 2
            if std[mid] == target :
                flag = True
                break
            elif std[mid] > target :
                right = mid - 1
            else :
                left = mid + 1
        if flag == True :
            print(1)
        else :
            print(0)

solution()