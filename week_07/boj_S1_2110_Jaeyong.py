N,C=map(int,input().split())
N_position=sorted(list(int(input()) for i in range(N)))
low=1
high=N_position[N-1]-N_position[0]

while(low<=high):
    mid=(low+high)//2
    a=1
    router=N_position[0]
    for i in range(1,N):
        if(router+mid<=N_position[i]):
            a+=1
            router=N_position[i]
    if(a<C):
        high=mid-1
    elif(a>=C):
        answer=mid
        low=mid+1
print(answer)
            
