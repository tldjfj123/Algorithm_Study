import sys
input = sys.stdin.readline

def solution() :
    while 1 :
        s = input().rstrip()

        stack = []
        if s == '.' :
            break

        for i in s :
            if i == '(' or i == '[' :
                stack.append(i)
            else :
                if i == ']' :
                    if not stack :
                        stack.append(i)
                    else :
                        if stack[-1] == '[' :
                            stack.pop()
                        else :
                            stack.append(i)
                elif i == ')' :
                    if not stack :
                        stack.append(i)
                    else :
                        if stack[-1] == '(' :
                            stack.pop()
                        else :
                            stack.append(i)
        
        if not stack :
            print('yes')
        else :
            print('no')

solution()