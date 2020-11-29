
N,K=map(int,input().split())
arr=list(map(lambda x:x,range(2,N+1)))
count=0
answer=0
while(K!=count):
    sosu=arr.pop(0)
    count+=1
    if(count==K):
        answer=sosu
        break
    for data in arr:
        if(data%sosu==0):
            arr.remove(data)
            count+=1
            if(count==K):
                answer=data
                break
print(answer)        
    


