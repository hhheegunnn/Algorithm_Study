'''https://www.acmicpc.net/problem/2750'''
'''수 정렬하기 '''



N = int(input())
num = []
for _ in range(N):
    num.append(int(input()))
num.sort()
for k in num:
    print(k)
