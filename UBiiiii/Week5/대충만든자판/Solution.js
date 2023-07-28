function solution(keymap, targets) {
    let map = {};
    keymap.forEach(key => {
        [...key].forEach((c, i) => {
            if(!map[c] || map[c] > i)   map[c] = i+1;
        })
    })
    
    return targets.map(target=>{
        let flag = false;
        let cnt = 0;
        for(const c of [...target]) {
            if(!map[c]) {
                flag = true;
                break;
            }
            cnt += map[c];
        }
        return flag ? -1 : cnt;
    });
}