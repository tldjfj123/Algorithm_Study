from itertools import combinations

def solution(number):
    combi = list(combinations(number, 3))
    res = 0

    for c in combi :
        if sum(c) == 0 :
            res += 1
    
    return res

solution([-2, 3, 0, 2, -5])