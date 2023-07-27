function solution(s) {
    let pos = {};
    return [...s].map((v,i) => {
        const cnt = pos[v]===undefined ? -1 : i-pos[v];
        pos[v]=i;
        return cnt
    });
}