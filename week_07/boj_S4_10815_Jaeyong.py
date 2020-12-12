M=int(input())
M_List=list(map(int,input().split()))
M_List.sort()
N=int(input())
N_List=list(map(int,input().split()))
for N_char in N_List:
    low=0
    high=M-1
    while(low<=high):
        mid=(low+high)//2
        if(M_List[mid]==N_char):
            print(1,end=' ')
            break
        elif(M_List[mid]<N_char):
            low=mid+1
        else:
            high=mid-1
    if(low<=high):
        print(0,end=' ')
