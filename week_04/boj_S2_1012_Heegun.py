"""https://www.acmicpc.net/problem/1012"""


"""week_04/boj_S2_1012_Heegun.py"""

"""[김희건] boj 유기농 배추"""

T = int(input())
result = []

def check_in(y,x):
    if 0<=x<c and 0<=y<r:
        return True
    else:
        return False

def dfs(y,x):
    board[y][x] = 0
    if check_in(y-1,x) and board[y-1][x] == 1:
        dfs(y-1,x)
    if check_in(y+1,x) and board[y+1][x] == 1:
        dfs(y+1,x)
    if check_in(y,x-1) and board[y][x-1] == 1:
        dfs(y,x-1)
    if check_in(y,x+1) and board[y][x+1] == 1:
        dfs(y,x+1)


for _ in range(T):
    c,r,k = map(int,input().split())

    #board[r][c]

    board =list([0]*c for _ in range(r))

    for _ in range(k):
        c_,r_ = map(int,input().split())

        board[r_][c_] = 1

    #print(board)

    bug_cnt = 0

    for i in range(r):
        for j in range(c):
            if board[i][j] == 1:
                dfs(i,j)
                bug_cnt += 1

    result.append(bug_cnt)

for r in result:
    print(r)












