function solution(food) {
    let str1 = '';
    let str2 = '';
    food.forEach((cnt, cal) => {
        if(cal!==0) {
            const num = Math.floor(cnt/2);
            for(let i=0;i<num;i++) {
                str1 = str1 + cal;
                str2 = cal + str2;
            }
        }
    })
    var answer = str1 + '0' + str2;
    return answer;
}