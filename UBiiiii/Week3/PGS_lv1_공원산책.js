function solution(park, routes) {
    var answer = [];
    let pos = [-1, -1];
    const H = park.length;
    const W = park[0].length;
    park.forEach((v,i)=>{
        if(v.includes("S")) pos = [i, v.indexOf("S")];
    });
    for (let route of routes) {
        const cmd = route.split(" ");
        const postPos = pos.slice(0);
        let flag = true;
        for(let i=0;i<cmd[1];i++) {
            switch(cmd[0]) {
                case "N":
                    postPos[0] -= 1;
                    break;
                case "S":
                    postPos[0] += 1;
                    break;
                case "W":
                    postPos[1] -= 1;
                    break;
                case "E":
                    postPos[1] += 1;
            }

            if(park[postPos[0]] === undefined
               || park[postPos[0]][postPos[1]] === undefined
               || park[postPos[0]][postPos[1]] === "X") {
                flag = false;
                break;
            }
        }

        if(flag)    pos = postPos;
    }

    return pos;
}