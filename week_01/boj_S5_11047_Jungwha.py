'''https://www.acmicpc.net/problem/11047'''
'''동전 0'''



N , K = map(int, input().split())
Alist = []
answernumber = 0
for j in range(N):
    a = int(input())
    Alist.append(a)
for i in range(N-1,-1,-1):
    if K >= Alist[i]:
        
        number = K//Alist[i]
        answernumber += number
        K = K%Alist[i]
    if K == 0:
        break
    else:
        pass
    
print(answernumber)