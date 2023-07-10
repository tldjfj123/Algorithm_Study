import sys, collections
input = sys.stdin.readline

def solution() :
    n = int(input())
    nums = [int(input()) for _ in range(n)]

    #산술평균
    print(round(sum(nums) / n))
    #중앙값
    print(sorted(nums)[n//2])
    #최빈값
    res = collections.Counter(nums).most_common()
    if n != 1 :
        res.sort(key = lambda x : (-x[1], x[0]))
        if res[0][1] == res[1][1] :
            print(res[1][0])
        else :
            print(res[0][0])
    else :
        print(nums[0])
    #범위
    print(abs(max(nums) - min(nums)))

solution()