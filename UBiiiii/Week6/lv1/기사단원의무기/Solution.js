function solution(number, limit, power) {
    var answer = 0;
    let arr = new Array(number).fill(0);
    arr.forEach((v,i)=>{
        let j=i;
        while(j<number) {
            arr[j]++;
            j += i+1;
        }
    })
    return arr.reduce((acc, curr) => acc+(curr>limit ? power : curr), 0);
}