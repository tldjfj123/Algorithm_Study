def solution(keymap, targets):
    result = []

    for target in targets :
        calc = 0 #횟수 계산기
        flag = False

        for t in target :
            tmp = [] #최소값 계산용
            # for문 돌면서 t 들어있나 확인
            for k in keymap :
                if t in k :
                    tmp.append(k.index(t))
            if not tmp :
                flag = True
                break
            else :
                calc += (min(tmp)+1)
        if not flag :
            result.append(calc)    
        else :
            result.append(-1)
    return result
        