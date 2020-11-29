from collections import deque
queue=deque()
N,M,V=map(int,input().split())
Map=[[0]*(N+1) for i in range(N+1)]
for i in range(M):
    x,y = map(int,input().split())
    Map[x][y]=1
    Map[y][x]=1

visited=[0]*(N+1)
def dfs(node):
    visited[node]=1
    print(node, end=' ')
    for i in range(1,N+1):
        if(visited[i]==0 and Map[node][i]==1):
            dfs(i)

visited=[0]*(N+1)
def bfs(node):
    queue.append(node) 
    visited[node]=1 
    while queue:
        node=queue.popleft()
        print(node, end=' ')
        for i in range(1, N+1):
            if(visited[i]==0 and Map[node][i]==1):
                queue.append(i)
                visited[i]=1

dfs(V)
print()
bfs(V)
