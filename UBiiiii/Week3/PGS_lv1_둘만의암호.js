function solution(s, skip, index) {
    const alpha = [..."abcdefghijklmnopqrstuvwxyz"];
    return [...s].map((v,i) => {
        let idx = alpha.indexOf(v);
        let cnt = 0;
        while(cnt < index) {
            if(skip.includes(alpha[++idx%26]))  continue;
            cnt++;
        }
        return alpha[idx%26];
    }).join("");
}