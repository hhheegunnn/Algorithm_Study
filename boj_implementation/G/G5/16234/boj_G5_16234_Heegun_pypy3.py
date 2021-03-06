"""https://www.acmicpc.net/problem/16234"""


""" 인구 이동 """
#약 120분

# git add boj_implementation/G/G5/16234/boj_G5_16234_Heegun_pypy3.py
# git commit -m "[김희건] boj 인구이동 [pypy3 통과, python사용시 시간초과]"

from collections import deque
import copy

delta = [(1,0),(-1,0),(0,1),(0,-1)]

def check_in(y,x):
    if 0<= y < N and 0<= x < N:
        return True
    else:
        return False

def diff_pop(y,x,ny,nx):
    if L <= abs(Board[y][x] - Board[ny][nx]) <= R:
        return True
    else:
        return False

def diff_n(y,x):
    for i in delta:
        ny,nx = y+i[0], x+i[1]
        if check_in(ny,nx):
            if L <= abs(Board[y][x] - Board[ny][nx]) <= R:
                return True
      
    return False



def bfs(start_r, start_c):
    
    start_node = [start_r, start_c]
    q = deque([start_node])
    visited[start_r][start_c] = True
    pop_sum = Board[start_r][start_c]
    nation = [[start_r,start_c]]

    while q:
        node = q.popleft()


        for d in delta:
            node_r = node[0]+d[0]
            node_c = node[1]+d[1]
            
            if check_in(node_r , node_c):
                if not visited[node_r][node_c]:
                    if diff_pop(node[0], node[1], node_r, node_c):
                        pop_sum += Board[node_r][node_c]
                        nation.append([node_r,node_c])
                        q.append([node_r, node_c])
                        visited[node_r][node_c] = True
    #print(nation)
    

    naiont_pop = pop_sum//len(nation)


    if len(nation) == 1:
        return False
    else:
        for i in nation:
            Board[i[0]][i[1]] = naiont_pop
        
        return True
    






N, L, R = map(int,input().split())
Board = [list(map(int,input().split())) for _ in range(N)]
cnt = 0


while True:

    visited = [[False for _ in range(N)] for _ in range(N)]
    
    flag = False

############ 여기서 줄여야함
    for r in range(N):
        for c in range(N):
            if not visited[r][c] and diff_n(r,c): 
                if bfs(r,c):
                    flag = True
############ 여기서 줄여야함 시간초과     
    if flag:
        cnt += 1
    else:
        print(cnt)
        break





