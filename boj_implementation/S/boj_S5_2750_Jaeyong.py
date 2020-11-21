N=int(input())
lst=[]
for data in range(N):
    lst.append(int(input()))
lst.sort()
for data in lst:
    print(data)