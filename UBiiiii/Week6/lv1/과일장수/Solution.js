function solution(k, m, score) {
    return score
        .sort((a,b)=>b-a)
        .reduce((acc, curr, i)=>
            (i+1)%m===0 ? acc+curr*m : acc
        , 0);
}