"""https://www.acmicpc.net/problem/11725"""


"""트리의 부모 찾기"""


# git add week_04/boj_S2_11725_Heegun.py

# git commit -m "[김희건] boj 트리의 부모 찾기"

from collections import defaultdict
import sys

sys.setrecursionlimit(10**6)

N = int(input())

tree = defaultdict(list)

result = [[] for _ in range(N+1)]

for _ in range(N-1):
    #s,e = map(int,input().split())
    s,e = map(int,sys.stdin.readline().split())

    tree[s].append(e)
    tree[e].append(s)

visited = [1]

stack = []

def dfs(s,tree,result):
    stack = [s]

    while stack:
        node = stack.pop()
        for i in tree[node]:
            result[i].append(node)
            stack.append(i)
            tree[i].remove(node)
            print(result)
    
    return result



for i in list(dfs(1,tree,result))[2:]:
    print(i[0])
