from collections import deque
T=int(input())
x = [-1,0, 1, 0]
y = [0, 1, 0, -1]
queue=deque()
def BFS(i_x,i_y):
    queue.append([i_x,i_y])
    while queue:
        pop_x, pop_y = queue.popleft()
        for i in range(4):
            dx = pop_x + x[i]
            dy = pop_y + y[i]
            if 0 <= dx < N and 0 <= dy < M and Map[dx][dy] == 1:
                Map[dx][dy] = 0
                queue.append([dx, dy])
for i in range(T):
    M, N, K = map(int, input().split())
    Map = [[0] * M for i in range(N)]
    cnt = 0
    for j in range(K):
        position_x, position_y = map(int, input().split())
        Map[position_y][position_x] = 1
    for i in range(N):
        for j in range(M):
            if Map[i][j] == 1:
                BFS(i, j)
                Map[i][j] = 0
                cnt += 1
print(cnt)
