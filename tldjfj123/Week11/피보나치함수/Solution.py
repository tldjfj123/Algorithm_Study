import sys
input = sys.stdin.readline


def solution() :
    n = int(input())

    for _ in range(n) :
        num = int(input())
        arr = []

        for i in range(num+1) :
            if i == 0 :
                arr.append((1, 0))
            elif i == 1 :
                arr.append((0, 1))
            else :
                tmp_zero = arr[i-2][0] + arr[i-1][0]
                tmp_one = arr[i-2][1] + arr[i-1][1]
                arr.append((tmp_zero, tmp_one))

        print(arr[-1][0], arr[-1][1])


solution()