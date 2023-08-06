function solution(k, score) {
    return score.reduce((acc, curr)=>{
        if(acc[0].length === 0) {
            acc[0].push(curr);
            acc[1].push(curr);
        } else {
            acc[1].push(curr);
            acc[1].sort((a,b)=>a-b);
            if(acc[1].length > k)  acc[1].shift();
            acc[0].push(acc[1][0]);
        }
        return acc;
    }, [[], []])[0];
}