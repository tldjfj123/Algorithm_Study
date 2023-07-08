import sys, itertools
input = sys.stdin.readline

def solution() :
    n, m = map(int, input().split())
    nums = list(set(map(lambda x : sum(x), itertools.permutations(list(map(int, input().split())), 3))))

    nums.sort(key = lambda x : abs((m - x)))

    for n in nums :
        if n <= m :
            print(n)
            break
solution()