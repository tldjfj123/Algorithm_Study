function solution(wallpaper) {
    let y = [];
    let x = [];
    wallpaper.forEach((v, i)=>{
        if(v.includes("#")) {
            x.push(i);
            y.push(v.indexOf("#"));
            y.push(v.lastIndexOf("#"));
        }  
    })
    return [Math.min(...x), Math.min(...y), Math.max(...x)+1, Math.max(...y)+1];
}