"""
mumu 5
soe 4
poe 3
kai 2 ++
mine 1 ++
"""

def solution(players, callings):
    rank = dict()
    i = 0

    for p in players :
        rank[p] = i
        i += 1
    
    #players = ["mumu", "soe", "poe", "kai", "mine"]
    #rank = {'mumu': 0, 'soe': 1, 'poe': 2, 'kai': 3, 'mine': 4}

    for c in callings :
        idx = rank[c] #3

        if idx != 0 :
            players[idx], players[idx-1] = players[idx-1], players[idx]
            #["mumu", "soe", "kai", "poe", "mine"]

            rank[players[idx]] = idx
            rank[players[idx-1]] = idx-1

    return players

solution(["mumu", "soe", "poe", "kai", "mine"]	,["kai", "kai", "mine", "mine"]	)