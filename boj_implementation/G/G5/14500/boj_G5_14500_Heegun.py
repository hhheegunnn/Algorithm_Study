"""https://www.acmicpc.net/problem/14500"""


"""테트로미노"""

# git add boj_implementation/G/G5/14500/boj_G5_14500_Heegun.py
# git commit -m "[김희건] boj 테트로미노"

def check_in(r,c):
    if 0<= r < N and 0<= c < M:
        return True
    else:
        return False


def solution(n,m,board):

    A_set = [(-1,0),(-1,1),(-1,2),(0,3),(1,2),(1,1),(1,0)]
    B_set = [(0,-1),(1,-1),(2,-1),(3,0),(2,1),(1,1),(0,1)]
    D_set = [(-1,1),(1,-1)]
    E_set = [(-1,0),(1,2)]

    max_A = 0
    max_B = 0
    max_C = 0
    max_D = 0
    max_E = 0
    
    # 가로로 3개따리 ----- A
    for r in range(n):
        for c in range(m-2):
            tmp = sum(board[r][c:c+3])
            # 7가지 확인
            for i in A_set:
                tmp_A = tmp
                rr = r + i[0]
                cc = c + i[1]
                if check_in(rr,cc):
                    tmp_A += board[rr][cc]

                    if tmp_A >= max_A:
                        max_A = tmp_A
                else:
                    continue
                
    # 세로로 3개따리 ----- B
    for r in range(n-2):
        for c in range(m):
            tmp = board[r][c] + board[r+1][c] + board[r+2][c]

            # 7가지 확인
            for i in B_set:
                tmp_B = tmp
                rr = r + i[0]
                cc = c + i[1]
                if check_in(rr,cc):
                    tmp_B += board[rr][cc]

                    if tmp_B >= max_B:
                        max_B = tmp_B
                else:
                    continue

    # 네모난 거 ---------- C
    for r in range(n-1):
        for c in range(m-1):
            tmp_C = board[r][c] + board[r][c+1] + board[r+1][c] + board[r+1][c+1]

            if tmp_C >= max_C:
                max_C = tmp_C

    # 계단 역ㄱ -------- D
    for r in range(n-1):
        for c in range(m-1):
            tmp = board[r][c] + board[r][c+1] + board[r+1][c]

            for i in D_set:
                tmp_D = tmp
                rr = r + i[0]
                cc = c + i[1]
                if check_in(rr,cc):
                    tmp_D += board[rr][cc]

                    if tmp_D >= max_D:
                        max_D = tmp_D
                else:
                    continue

    # 계단 ㄱ -------- E
    for r in range(n-1):
        for c in range(m-1):
            tmp = board[r][c] + board[r][c+1] + board[r+1][c+1]

            for i in E_set:
                tmp_E = tmp
                rr = r + i[0]
                cc = c + i[1]
                if check_in(rr,cc):
                    tmp_E += board[rr][cc]

                    if tmp_E >= max_E:
                        max_E = tmp_E
                else:
                    continue



    return max(max_A,max_B,max_C,max_D,max_E)



N,M = map(int,input().split())
board = []

for _ in range(N):
    board.append(list(map(int,input().split())))



print(solution(N,M,board))