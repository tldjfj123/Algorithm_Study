import sys
input = sys.stdin.readline

"""
1 : 1개
2 ~ 7 : 6개
8 ~ 19 : 12개
20 ~ 37 : 18개
38 ~ 63 : 24개
"""

def solution() :
    n = int(input())
    
    hive = 1
    floor = 0
    while n > hive :
        hive += floor * 6
        floor += 1
    
    if n == 1 :
        print(1)
    else :
        print(floor)

solution()