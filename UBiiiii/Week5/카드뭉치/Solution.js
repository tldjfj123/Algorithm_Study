function solution(cards1, cards2, goal) {

    for(const g of goal) {
        if(cards1[0]==g)   cards1.shift();
        else if(cards2[0]==g)  cards2.shift();
        else {
            return 'No';
        }
    }
    return 'Yes';
}