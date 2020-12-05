#BFS 
from collections import deque

M,N,K=map(int,input().split())
Map=[[0]*N for _ in range(M)]
map_size=[]
for _ in range(K):
    square_x1,square_y1,square_x2,square_y2=map(int,input().split())
    for i in range(square_x1,square_x2):
        for j in range(square_y1,square_y2):
            Map[j][i]=1
    

x=[-1,0,1,0]
y=[0,1,0,-1]

def BFS(i_x,i_y):
    queue=deque()
    queue.append([i_x,i_y])
    Map[i_x][i_y]=1
    map_count=1

    while(queue):
        pop_x,pop_y=queue.popleft()
        for _ in range(4):
            dx=pop_x+x[_]
            dy=pop_y+y[_]
            if(0<=dx<M and 0<=dy<N and Map[dx][dy]==0):
                Map[dx][dy]=1
                map_count+=1
                queue.append([dx,dy])
    map_size.append(map_count)

for i in range(N):
    for j in range(M):
        if(Map[j][i]==0):
            BFS(j,i)
print(len(map_size))
for i in sorted(map_size):
    print(i,end=' ')
