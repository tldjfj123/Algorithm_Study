from collections import deque

def solution(s):
    arr = deque(list(s))
    result = 0

    while len(arr) > 0:
        std = arr[0]
        same_cnt = 0
        diff_cnt = 0
        
        for i in range(len(arr)):
            if std == arr[i]:
                same_cnt += 1
            else:
                diff_cnt += 1
            
            if same_cnt == diff_cnt:
                result += 1
                for _ in range(same_cnt + diff_cnt):
                    arr.popleft()
                break
        
        if same_cnt != diff_cnt:
            result += 1
            break

    return result