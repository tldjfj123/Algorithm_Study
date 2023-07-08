import sys
input = sys.stdin.readline

def is_prime(n : int) -> bool :
    if n == 1 :
        return False
    
    for i in range(2, int(n ** 0.5) + 1) :
        if n % i == 0 :
            return False
    return True


def solution() :
    n = int(input())
    nums = list(map(int, input().split()))
    res = 0

    for n in nums :
        if is_prime(n) == True :
            res += 1
    print(res)

solution()