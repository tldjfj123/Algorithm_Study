function solution(name, yearning, photo) {
    return photo.map(p=>p.reduce((pre, curr)=>pre += yearning[name.indexOf(curr)] || 0, 0));
}