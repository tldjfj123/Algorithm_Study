from collections import deque
import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    cards = deque([i for i in range(1, n+1)])

    while len(cards) != 1 :
        cards.popleft()
        cards.append(cards.popleft())
    
    print(cards[0])

solution()