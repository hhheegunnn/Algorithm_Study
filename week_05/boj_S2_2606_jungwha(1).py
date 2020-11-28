import sys
sys.setrecursionlimit(1000000)

N = int(input())
K = int(input())

visited = [False]*(N+1)
graph = [[] for _ in range(N+1)]
for _ in range(K):
    a,b =map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)
    
    
    
def solution(graph, v, visited):
    
    for i in graph[v]:
        visited[v] = True
        if not visited[i]:
            solution(graph, i, visited)
    
solution(graph,1,visited)
if visited.count(True) == 0: #1에 연결된 노드가 없을때
    print(0)
else:
    print(visited.count(True)-1)
