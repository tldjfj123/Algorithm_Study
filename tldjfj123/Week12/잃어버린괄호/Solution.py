import sys
input = sys.stdin.readline

"""
-가 문제임 -> -를 구분자로 분리
eval 함수를 쓸려고 했으니 시작이 0 인 경우때문에 탈락!
"""

def solution() :
    s = input().rstrip()
    if '-' not in s :
        print(sum(list(map(int, s.split('+')))))
    else :
        s = s.split("-")
        std = sum(list(map(int, s[0].split('+'))))
        s = s[1 : ]
        for s in s :
            std -= sum(list(map(int, s.split('+'))))
        print(std)
solution()