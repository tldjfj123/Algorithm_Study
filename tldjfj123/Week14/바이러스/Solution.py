import sys
input = sys.stdin.readline

def solution() :
    v = int(input())
    m = int(input())
    graph = [[] for _ in range(v+1)]
    for _ in range(m) :
        start, end = map(int, input().split())
        graph[start].append(end)
        graph[end].append(start)
    
    visited = [False for _ in range(v+1)]
    dfs(graph, visited, 1, 0)
    print(sum(visited) - 1)

def dfs(graph, visited, start, res) :
    visited[start] = True

    for node in graph[start] :
        if not visited[node] :
            dfs(graph, visited, node, res+1)

solution()