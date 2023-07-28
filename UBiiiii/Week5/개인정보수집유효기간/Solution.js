function solution(today, terms, privacies) {
    var answer = [];
    let map = {};
    const [ty, tm, td] = today.split(".");
    terms.forEach(v=>{
        map[v[0]] = v.slice(2);
    })
    
    return privacies.reduce((acc, curr, i)=>{
        const privacy = curr.split(" ");
        const [dy, dm, dd] = privacy[0].split(".");
        const y = ty - dy;
        const m = tm - dm - map[privacy[1]];
        const d = td - dd;
        if(y*12*28 + m*28 + d >= 0) acc.push(i+1);
        return acc
    }, []);
}