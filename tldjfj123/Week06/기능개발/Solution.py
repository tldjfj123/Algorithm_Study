from collections import deque

def solution(progresses, speeds):
    progresses = deque(progresses)
    speeds = deque(speeds)
    res = []
    
    while progresses :
        for i in range(len(speeds)) :
            progresses[i] += speeds[i]
        
        cnt = 0
        while progresses :
            if progresses[0] >= 100 :
                progresses.popleft()
                speeds.popleft()
                cnt += 1
            else :
                break
        
        if cnt != 0 :
            res.append(cnt)
    return res