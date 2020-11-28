from collections import deque
x=[-1,0,1,0]
y=[0,1,0,-1]
M,N=map(int,input().split())
queue=deque()
box=[]

for i in range(N):
    box.append(list(map(int,input().split())))

for i in range(N):
    for j in range(M):
        if box[i][j] == 1:
            queue.append([i, j])

while(queue):
    pop_x,pop_y=queue.pop(0)
    for i in range(4):
        dx=pop_x+x[i]
        dy=pop_y+y[i]
        if(0<=dx<N and 0<=dy<M and box[dx][dy]==0):
            box[dx][dy]=box[pop_x][pop_y]+1
            queue.append([dx,dy])

flag=False
answer=-2
for line in box:
    for component in line:
        if(component==0):
            flag=True
            break
        answer=max(answer,component)
    if(flag==True):
        print(-1)
        break
if(flag==False and answer==-1):
    print(0)
elif(flag==False):
    print(answer-1)
        
    
