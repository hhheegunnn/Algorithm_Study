from collections import Counter
import sys 


N=int(sys.stdin.readline())
data=[]
for i in range(N):
    data.append(int(sys.stdin.readline()))

data=sorted(data)
#Arithmetic mean
data_sum=sum(data)
print(round(data_sum/N))
#median

if(N%2==1):
    print(data[int((N+1)/2-1)])
else:
    tmp=(data[N//2]+data[N//2+1])/2
    print(tmp)
#multimode
same_multi_lst=[]
multi=Counter(data)

most_count=multi.most_common()[0][1]
for dt in multi.most_common():
    if(dt[1]!=most_count):
        break
    same_multi_lst.append(dt[0])
if(len(same_multi_lst)>1):
    print(sorted(same_multi_lst)[1])
else:
    print(same_multi_lst[0])

#range
print(data[N-1]-data[0])


