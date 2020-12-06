T=int(input())
forT=int(input())
for _ in range(T):
    N=int(input())
    tree=list(map(int,input().split()))
    tree.sort(reverse=True)
    answer=0
    for i in range(N-2):
        answer=max(answer,tree[i]-tree[i+2])
    print(answer)
    
    
