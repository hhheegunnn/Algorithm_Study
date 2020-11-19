'''https://www.acmicpc.net/problem/2606'''
'''바이러스'''


N = int(input())
K = int(input())
mapdic = {}
for i in range(N):
    mapdic[i+1] = set()
for _ in range(K):
    a, b = map(int, input().split())
    mapdic[a].add(b)
    mapdic[b].add(a)
def solution(start):
    global mapdic
    for i in mapdic[start]:
        if i not in visited:
            visited.append(i)
            solution(i)
visited = []

solution(1)    



print(len(visited)-1)        
