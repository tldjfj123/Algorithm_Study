function solution(s, skip, index) {
    const alpha = [..."abcdefghijklmnopqrstuvwxyz"].filter(v=>!skip.includes(v));
    return [...s].map((v,i) => {
        let idx = alpha.indexOf(v)+index;
        return alpha[idx%alpha.length];
    }).join("");
}