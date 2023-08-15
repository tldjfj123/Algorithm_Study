def solution(survey, choices):
    # R / T, C / F, J / M, A / N
    table1 = {"R" : 0, "C" : 0, "J" : 0, "A" : 0}
    table2 = {"T" : 0, "F" : 0, "M" : 0, "N" : 0}
    
    for i in range(len(survey)) :
        keyword = survey[i]
        score = choices[i]
        if list(keyword) == sorted(keyword) : # 그대로
            if score < 4 :
                table1[keyword[0]] += (4 - score)
            else :
                table2[keyword[1]] += (score - 4)
        else : # 반대
            if score > 4 :
                table1[keyword[1]] += (score - 4)
            else :
                table2[keyword[0]] += (4 - score)
        
    key1 = list(table1.keys())
    key2 = list(table2.keys())
    
    res = []
    
    for i in range(len(key1)) :
        if table1[key1[i]] >= table2[key2[i]] :
            res.append(key1[i])
        else :
            res.append(key2[i])
    
    return ''.join(res)
            
            
    
        
        