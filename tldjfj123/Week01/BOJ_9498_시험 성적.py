import sys
input = sys.stdin.readline

def solution() :
    n = int(input())

    if 90 <= n <= 100 :
        print('A')
    elif 80 <= n < 90 :
        print('B')
    elif 70 <= n < 80 :
        print('C')
    elif 60 <= n < 70 :
        print('D')
    else :
        print('F')

solution()