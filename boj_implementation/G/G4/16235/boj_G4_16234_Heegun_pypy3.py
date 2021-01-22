"""https://www.acmicpc.net/problem/16235"""


""" 나무 재테크 """

def spring_summer():

    for r in range(N):
        for c in range(N):
            if T[r][c]:
                T[r][c].sort()
                dt = 0
                tmp = []
                for age in T[r][c]:
                    if age <= board[r][c]:
                        board[r][c] -= age
                        age += 1
                        if age%5 == 0:
                            GT.append((r,c))
                        tmp.append(age)
                    else:
                        dt += age//2

                board[r][c] += dt
                T[r][c] = []
                T[r][c].extend(tmp)
                       

    
def fall():

    while GT:
        r,c = GT.pop()
        d = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        for dr,dc in d:
            nr = r + dr
            nc = c + dc
            if 0<= nr < N and 0<= nc < N:
                T[nr][nc].append(1)
            


def winter():
    for i in range(N):
        for j in range(N):
            board[i][j] += A[i][j]



N, M, K = map(int,input().split())

board = [[5 for _ in range(N)] for _ in range(N)]

A = [list(map(int,input().split())) for _ in range(N)]
T = [[[] for _ in range(N)] for _ in range(N)]
GT = []

for _ in range(M):
    y,x,z = map(int,input().split())
    T[y-1][x-1].append(z)



for _ in range(K):

    spring_summer()
    fall()
    winter()


total_tree = 0

for i in range(N):
    for j in range(N):
        total_tree += len(T[i][j])


print(total_tree)
        
