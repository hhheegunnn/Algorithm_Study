'''https://www.acmicpc.net/problem/11399'''
'''ATM'''

N = int(input())
time = list(map(int, input().split()))
time.sort()
sumtime = []
for k in range(len(time)):
    sumtime.append(sum(time[:k+1]))

print(sum(sumtime))

