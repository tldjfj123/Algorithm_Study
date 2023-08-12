def solution(X, Y):
    table_x = set(X)
    table_y = set(Y)
    
    common = table_x & table_y
    pair = []
    
    for i in range(9, -1, -1) :
        if str(i) in common :
            tmp = min(X.count(str(i)), Y.count(str(i)))
            for _ in range(tmp) :
                pair.append(str(i))
    
    if not pair :
        return "-1"
    elif pair.count("0") == len(pair) :
        return "0"
    else :
        return ''.join(pair)