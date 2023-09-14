import sys
input = sys.stdin.readline
from collections import deque

"""
가장 짧다 -> bfs!
"""


def solution() :
    start, goal = map(int, input().split())

    visited = [0 for _ in range(100001)]
    queue = deque([start])

    while queue :
        v = queue.popleft()
        if v == goal :
            print(visited[v])
            break
        cases = [v - 1, v + 1, v * 2]

        for c in cases :
            if 0 <= c <= 100000 and not visited[c] :
                queue.append(c)
                visited[c] = visited[v] + 1

solution()