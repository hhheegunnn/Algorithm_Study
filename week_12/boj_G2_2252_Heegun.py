"""https://www.acmicpc.net/problem/2252"""


""" 줄 세우기 """

# git add week_12/boj_G2_2252_Heegun.py
# git commit -m "[김희건] boj 줄 세우기 [위상정렬 기본]"

from collections import deque

v,e = map(int,input().split())

indegree = [0] *(v+1)

graph = [[] for i in range(v+1)]

for _ in range(e):
    a,b = map(int,input().split())
    graph[a].append(b)
    indegree[b] += 1


def topology_sort():
    result = []
    q = deque()

    for i in range(1,v+1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()
        result.append(now)
        for i in graph[now]:
            indegree[i] -= 1

            if indegree[i] == 0:
                q.append(i)

    return result

a = topology_sort()

print(*a)