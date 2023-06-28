import sys, math
input = sys.stdin.readline

def solution() :
    n = int(input())

    for _ in range(n) :
        # h = 높이, w = 너비, n = n번째 손님
        h, w, n = map(int, input().split())
        head = n % h

        if head == 0 :
            head = h
                
        tail = int(math.ceil(n / h))

        if tail < 10 :
            print(f'{head}0{tail}')
        else :
            print(f'{head}{tail}')

solution()