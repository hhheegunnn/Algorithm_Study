###시간초과

from sys import stdin
N, M = map(int, stdin.readline().split())
nummap = []

for _ in range(N):
    a = list(map(int, stdin.readline().split()))
    nummap.append(a)
for _ in range(M):
    answer = 0
    xys = []
    xys = list(map(int, stdin.readline().split()))
    
    if xys[0] > xys[2]:
        xys[0], xys[2] = xys[2], xys[0]
    if xys[1] > xys[3]:
        xys[1], xys[3] = xys[3], xys[1]
    for r in range(N):
        if xys[0]-1 <= r <=xys[2]-1:
            for c in range(N):
                if xys[1]-1 <= c <= xys[3]-1:
                    answer += nummap[r][c]
    print(answer)


### 통과
import sys

input = sys.stdin.readline
n, m = map(int, input().split())
square = [list(map(int,input().split())) for _ in range(n)]
for k in range(2):
    for i in range(n):
        if k == 1 and i == 0:
            continue
        for j in range(n):
            if k == 0:
                if j == 0:
                    continue
                square[i][j] += square[i][j-1]
            else:
                square[i][j] += square[i-1][j]


for i in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    if x1 == 1 and y1 == 1:
        print(square[x2-1][y2-1])
    elif x1 == 1:
        print(square[x2-1][y2-1] - square[x2-1][y1-2])
    elif y1 == 1:
        print(square[x2-1][y2-1] - square[x1-2][y2-1])
    else:
        print(square[x2-1][y2-1] - square[x1-2][y2-1] - square[x2-1][y1-2] + square[x1-2][y1-2])