import sys
from collections import deque
input = sys.stdin.readline

"""
최솟값 찾기 --> bfs!!
"""


def solution() :
    n, m = map(int, input().split())
    arr = [list(map(int, input().rstrip())) for _ in range(n)]

    dx = [0, 0, -1, 1] # 상하좌우
    dy = [-1, 1, 0, 0]

    queue = deque([[0, 0]])

    while queue :
        v = queue.popleft()
        for i in range(4) :
            nx = v[0] + dx[i]
            ny = v[1] + dy[i]

            if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 1 :
                arr[nx][ny] = arr[v[0]][v[1]] + 1
                queue.append([nx, ny])

    print(arr[n-1][m-1])

solution()