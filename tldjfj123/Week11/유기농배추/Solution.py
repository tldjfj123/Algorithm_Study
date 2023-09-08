import sys
from collections import deque
input = sys.stdin.readline

def solution() :
    T = int(input())

    for _ in range(T) :
        M, N, K = map(int, input().split())

        arr = [[0 for _ in range(N)] for _ in range(M)]
        
        for _ in range(K) :
            x, y = map(int, input().split())
            arr[x][y] = 1
        
        #bfs
        queue = deque()

        dx = [0, 0, -1, 1] #상하좌우
        dy = [-1, 1, 0, 0]

        res = 0
        for i in range(M) :
            for j in range(N) :
                if arr[i][j] == 1 :
                    queue.append([i, j])
                    arr[i][j] = 0
                    res += 1

                    while queue :
                        v = queue.popleft()

                        for k in range(4) :
                            nx = v[0] + dx[k]
                            ny = v[1] + dy[k]

                            if 0 <= nx < M and 0 <= ny < N :
                                if arr[nx][ny] == 1 :
                                    queue.append([nx, ny])
                                    arr[nx][ny] = 0
        print(res)        
        
solution()