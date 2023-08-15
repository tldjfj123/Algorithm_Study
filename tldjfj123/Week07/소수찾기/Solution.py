from itertools import permutations
import math

def is_prime(x):
    if x < 2:  # 1과 2 미만의 수는 소수가 아님
        return False
    if x == 2:  # 2는 소수
        return True
    
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True

def solution(numbers):
    numbers = list(numbers)
    nums = []
    
    for i in range(1, len(numbers) + 1) :
        comb = list(map(lambda x : int(''.join(x)), list(permutations(numbers, i))))
        
        for c in comb :
            nums.append(c)
            
    nums = list(set(nums))
    
    res = 0
    
    for n in nums :
        if is_prime(n) :
            res += 1
    
    return res