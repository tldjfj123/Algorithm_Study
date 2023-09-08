import sys
from collections import deque
input = sys.stdin.readline

def dfs(graph, visited, v) :
    visited[v] = True
    print(v, end = ' ')
    graph[v].sort()
    for i in graph[v] :
        if not visited[i] :
            dfs(graph, visited, i)

def solution() :
    n, m, v = map(int, input().split())
    #인접 리스트 생성
    graph = [[] for _ in range(n+1)]

    for _ in range(m) :
        start, end = map(int, input().split())
        graph[start].append(end)
        graph[end].append(start)

    #dfs
    visited_dfs = [False for _ in range(n+1)]
    dfs(graph, visited_dfs, v)
    print()

    #bfs
    visited_bfs = [False for _ in range(n+1)]
    queue = deque()
    queue.append(v)

    while queue :
        v = queue.popleft()

        if not visited_bfs[v] :
            print(v, end = ' ')
            visited_bfs[v] = True
            graph[v].sort()
            for i in graph[v] :
                queue.append(i)

solution()
