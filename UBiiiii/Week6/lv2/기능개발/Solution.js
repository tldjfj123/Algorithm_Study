function solution(progresses, speeds) {
    let day = 0;
    return progresses.reduce((acc, curr, i)=>{
        while(curr + speeds[i]*day < 100) day++;
        acc[day] = acc[day] ? acc[day]+1 : 1;
        return acc;
    }, []).filter(el=>el!=0);
}