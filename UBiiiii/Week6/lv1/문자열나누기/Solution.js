function solution(s) {
    return [...s].reduce((acc, curr)=>{
        if(acc[1]===acc[2]) {
            acc[1] = 1;
            acc[2] = 0;
            acc[0] = curr;
            acc[3]++;
        } else {
            acc[acc[0]===curr ? 1 : 2 ]++;
        }
        return acc;
    }, ['', 0, 0, 0])[3];
}