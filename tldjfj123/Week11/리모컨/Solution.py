import sys
input = sys.stdin.readline
from itertools import product
"""
채널 이동 경우의 수 (시작지점 : 100)
1. +, - 딸깍딸깍
2. 번호 조합해서 바로 해당 채널로 이동
3. 깨진 번호로인해 바로 이동 못 하여 1, 2를 합친 경우
"""

def solution() :
    n = int(input())
    m = int(input())
    if m != 0 :
        broken = input().split()

        #1번 케이스
        case = abs(n - 100)
   
        #2번 케이스
        for num in str(n) :
            if num in broken :
                break
        else :
            case = min(case, len(str(n)))

        #3번 케이스
        #살아있는 키패드로 생성가능한 모든 숫자 경우 생성
        nums = []
        for i in range(10) :
            if str(i) not in broken :
                nums.append(str(i))
        
        res = []
        for i in range(1, 8) :
            tmp = list(map(lambda x : int(''.join(x)), product(nums, repeat = i))) ##기준 숫자의 자릿수보다 더 큰 수에서 탐색이 더 빠를 수 있음
            for t in tmp :
                res.append(t)
        
        for r in res :
            case = min(case, abs(r - n) + len(str(r)))
        
        print(case)
    else :
        print(min(len(str(n)), abs(n - 100)))
solution()