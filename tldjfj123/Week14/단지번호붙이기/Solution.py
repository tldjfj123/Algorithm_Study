import sys
input = sys.stdin.readline
from collections import deque

def solution() :
    n = int(input())
    graph = [list(map(int, input().rstrip())) for _ in range(n)]
    
    row = len(graph[0]) # 정사각형인거 쓰고나니까 알았네 ㅆㅂ
    column = n
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    res = []
    for i in range(row) :
        for j in range(column) :
            if graph[i][j] == 1 :
                tmp = 1 # 단지 수 덧셈 용 
                queue = deque([[i, j]])
                graph[i][j] = 0

                while queue :
                    v = queue.popleft()

                    for k in range(4) :
                        nx = v[0] + dx[k]
                        ny = v[1] + dy[k]
                    
                        if 0 <= nx < row and 0 <= ny < column and graph[nx][ny] == 1  :
                            graph[nx][ny] = 0
                            tmp += 1
                            queue.append([nx, ny])
                if tmp != 0 :
                    res.append(tmp)
    print(len(res))
    res.sort()
    for r in res :
        print(r)

solution()