import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    stack = []

    for _ in range(n) :
        order = input().rstrip()
        if len(order.split()) == 2 :
            stack.append(order.split()[1])
        else :
            if order == 'pop' :
                if not stack :
                    print(-1)
                else :
                    print(stack.pop())
            elif order == 'size' :
                print(len(stack))
            elif order == 'empty' :
                if not stack : 
                    print(1)
                else :
                    print(0)
            elif order == 'top' :
                if not stack : 
                    print(-1)
                else :
                    print(stack[-1])

solution()