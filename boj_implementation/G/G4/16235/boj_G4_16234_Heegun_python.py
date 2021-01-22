"""https://www.acmicpc.net/problem/16235"""


""" 나무 재테크 """

from collections import defaultdict


def spring_summer():

    for r in range(N):
        for c in range(N):
            dt = 0
            tmp = defaultdict(lambda:0)

            for age,tn in sorted(T[r][c].items()):
                alive = min(board[r][c]//age, tn)
                dead = tn - alive
                if alive > 0:
                    board[r][c] -= age*alive
                    tmp[age+1] += alive
                dt += (age//2)*dead
            
            T[r][c] = tmp
            board[r][c] += dt
                       

    
def fall():
    d = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
    for r in range(N):
        for c in range(N):
            for age,tn in T[r][c].items():
                if age%5 == 0 and tn != 0:
                    for dr,dc in d:
                        nr = r + dr
                        nc = c + dc
                        if 0<= nr < N and 0<= nc < N:
                            T[nr][nc][1] += tn
        


def winter():
    for i in range(N):
        for j in range(N):
            board[i][j] += A[i][j]



N, M, K = map(int,input().split())

board = [[5 for _ in range(N)] for _ in range(N)]

A = [list(map(int,input().split())) for _ in range(N)]
T = [[defaultdict(lambda :0) for _ in range(N)] for _ in range(N)]
GT = []

for _ in range(M):
    y,x,z = map(int,input().split())
    T[y-1][x-1][z] += 1




for _ in range(K):

    spring_summer()
    fall()
    winter()


total_tree = 0

for i in range(N):
    for j in range(N):
        for age,tn in T[i][j].items():
            total_tree += tn


print(total_tree)
        

"""
3 3 1
2 2 2
2 2 2
2 2 2
1 1 5
1 1 6
1 1 4
"""