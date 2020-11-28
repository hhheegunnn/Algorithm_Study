computers=int(input())
networks=int(input())

connected=[[0]*computers for i in range(computers)]
visited=[]

for i in range(networks):
    cmts_1,cmts_2=map(int,input().split())
    connected[cmts_1-1][cmts_2-1]=1
    connected[cmts_2-1][cmts_1-1]=1



def DFS(idx):
    visited.append(idx)
    for computer in range(computers):
        if(computer not in visited and connected[idx][computer]==1):
            DFS(computer)
    return len(visited)-1

print(DFS(0))
    
