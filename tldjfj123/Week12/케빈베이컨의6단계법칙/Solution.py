import sys
input = sys.stdin.readline
from collections import deque

def solution() :
    n, m = map(int, input().split())

    graph = [[] for _ in range(n+1)]

    for _ in range(m) :
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    kevin = []

    for i in range(1, n+1) : # 1번부터 케빈베이컨 수 탐색
        visited = [0 for _ in range(n+1)]
        queue = deque()
        queue.append(i)
        
        while queue :
            v = queue.popleft()

            for j in graph[v] :
                if not visited[j] :
                    queue.append(j)
                    visited[j] = visited[v] + 1
        kevin.append(sum(visited) - visited[i])
    
    print(kevin.index(min(kevin)) + 1)

solution()