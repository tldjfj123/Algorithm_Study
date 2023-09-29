import sys
from collections import deque
input = sys.stdin.readline

def solution() :
    T = int(input())

    for _ in range(T) :
        order = input().rstrip()
        r_check = False
        error_check = False

        n = int(input())
        if n != 0 :
            arr = deque(list(map(int, input().rstrip()[1 : -1].split(","))))
        else :
            tmp = input().rstrip()
            arr = deque([])

        for o in order : 
            if o == 'R' :
                if not r_check : 
                    r_check = True
                else :
                    r_check = False
            else :
                if arr :
                    if r_check :
                        arr.pop()
                    else :
                        arr.popleft()
                else :
                    error_check = True
                    break
            
        result = list(map(str, list(arr)))
        
        if not error_check :
            if r_check :
                print("[" + ",".join(result[::-1]) + "]")  # R 상태일 때는 결과를 뒤집어서 출력
            else :
                print("[" + ",".join(result) + "]")  # 그 외의 경우는 결과 그대로 출력
        else :
            print("error")  # 에러 발생시 에러 출력

solution()