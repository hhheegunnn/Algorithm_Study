"""https://www.acmicpc.net/problem/17144"""



"""미세먼지 안녕"""

# git add boj_implementation/G/G5/17144/boj_G5_17144_Heegun_pypy3.py
# git commit -m "[김희건] boj 미세먼지 안녕 [pypy3 통과, python 최적화 필요] "

delta = [(1,0), (-1,0), (0,1), (0,-1)]

def check_in_c(y,x):
    if 0<= y < R and 0<= x < C and board[y][x] != -1:
        return True
    else:
        return False

def cal(T):
    for t in T:
        r = t[0]
        c = t[1]
        a = t[2]
        board[r][c] += a

def H():
    tmp = []
    cleaner = []

    for r in range(R):
        for c in range(C):

            if board[r][c] == -1:
                cleaner.append([r,c])

            if board[r][c] >= 1:
                s_air = board[r][c]//5
                s_cnt = 0
                for d in delta:
                    sr = r+d[0]
                    sc = c+d[1]
                    if check_in_c(sr, sc):
                        tmp.append((sr,sc,s_air))
                        s_cnt += 1
                board[r][c] -= (s_air * s_cnt) 
    cal(tmp)

    return cleaner


# ucr, ucc = 공기 청정기의 위쪽 좌표
def move_air_up(ucr, ucc):

    # 공기청정기 위로 들어오는 공기 처리

    Q = board[ucr][C-1]
    W = board[0][C-1]
    E = board[0][0]


    for c in range(C-1,-1,-1):
        board[ucr][c] = board[ucr][c-1]
    
    for r in range(ucr):
        board[r][C-1] = board[r+1][C-1]
    
    for c in range(C-1):
        board[0][c] = board[0][c+1]

    for r in range(ucr,0,-1):
        board[r][0] = board[r-1][0]
    
    board[ucr][ucc] = -1
    board[ucr][ucc+1] = 0
    board[ucr-1][C-1] = Q
    board[0][C-2] = W
    board[1][0] = E
    

         



# dcr, dcc = 공기 청정기의 아래쪽 좌표
def move_air_down(dcr, dcc):

    Q = board[dcr][C-1]
    W = board[R-1][C-1]
    E = board[R-1][0]


    for c in range(C-1,-1,-1):
        board[dcr][c] = board[dcr][c-1]
    
    for r in range(R-1,dcr+1,-1):
        board[r][C-1] = board[r-1][C-1]
    
    for c in range(C-1):
        board[R-1][c] = board[R-1][c+1]

    for r in range(dcr,R-2):
        board[r][0] = board[r+1][0]
    
    board[dcr][dcc] = -1
    board[dcr][dcc+1] = 0
    board[dcr+1][C-1] = Q
    board[R-1][C-2] = W
    board[R-2][0] = E




R,C,T = map(int,input().split())

board = [list(map(int,input().split())) for _ in range(R)]


for _ in range(T):
    clean = H()
    #print(clean)
    move_air_up(clean[0][0], clean[0][1])
    move_air_down(clean[1][0], clean[1][1])


result = 0

for r in range(R):
    for c in range(C):
        if board[r][c] >= 1:
            result += board[r][c]

#print(board)
print(result)


