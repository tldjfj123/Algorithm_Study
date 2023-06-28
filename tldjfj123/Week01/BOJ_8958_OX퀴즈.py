import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    for _ in range(n) :
        ans = input().rstrip()
        res = 0
        stack = []
        
        for i in range(len(ans)) :
            if ans[i] == 'O' :
                stack.append(ans[i])
            else :
                stack = []
            res += len(stack)

        print(res)

solution()