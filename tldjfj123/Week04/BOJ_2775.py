import sys
input = sys.stdin.readline

"""
1 3 6 10 15 21 28 36 45
1 2 3 4 5 6 7 8 9 
"""

def solution() :
    n = int(input())
    
    for _ in range(n) :
        a = int(input()) #층
        b = int(input()) #호

        std = []

        for i in range(a) :
            tmp = []
            for j in range(1, b+1) :
                if i == 0 :
                    tmp.append(j)
                else :
                    tmp.append(sum(std[i-1][:j]))
            std.append(tmp)
    
        print(sum(std[-1]))
        
solution()