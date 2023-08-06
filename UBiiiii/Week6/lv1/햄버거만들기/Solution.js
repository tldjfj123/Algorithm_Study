function solution(ingredient) {
    var answer = 0;
    let str = ingredient.join("");
    while(str.includes("1231")) {
        answer++;
        str = str.replace("1231", "");
    }
    return answer;
}