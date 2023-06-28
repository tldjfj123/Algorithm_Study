import sys
input = sys.stdin.readline

def solution() :
    a, b = map(int, input().split())

    if a > b :
        print('>')
    elif a < b :
        print('<')
    else :
        print('==')

solution()