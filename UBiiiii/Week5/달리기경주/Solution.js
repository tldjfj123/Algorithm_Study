function solution(players, callings) {
    var answer = [];
    let position = {};
    players.forEach((v, i) => {
        position[v] = i;
    })
    callings.forEach(el => {
        const curr = position[el];
        const pre = players[curr-1];
        players[curr-1] = players[curr];
        players[curr] = pre;
        position[el] = curr-1;
        position[pre] = curr;
    });

    return players;
}