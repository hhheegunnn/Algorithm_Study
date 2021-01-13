"""https://www.acmicpc.net/problem/15684"""


"""사다리 조작"""

# git add boj_implementation/G/G5/15684/Re_boj_G5_15684_Heegun_pypy3.py
# git commit -m "[김희건] boj 사다리 조작 [어렵, python최적화 시도 못함, 걍 어렵]"

def check(pos) : ## 사다리 진행
    #print(n)
    for c in range(n):
        pre = c
        for r in range(h) :
            if pos[r][c] :
                c += 1
            elif c > 0 and pos[r][c-1] :
                c -= 1
        if pre != c : # 시작과 끝이 다르면
            return False
    # 시작과 끝이 같다면
    return True


def bf(cnt,x,y):
    global ans
    if check(pos):
        ans = min(ans,cnt)
        return
    elif cnt == 3 or ans <= cnt:
        return
    
    for i in range(x,h):
        if i == x:
            k = y
        else:
            k = 0
        for j in range(k, n-1):
            """
            if not pos[i][j] and not pos[i][j+1]:
                pos[i][j] = True
                bf(cnt+1,i,j+2)
                pos[i][j] = False
            """
            if pos[i][j]:
                continue
            if j+1 < n and pos[i][j+1]:
                continue
            if j-1 > 0 and pos[i][j-1]:
                continue

            pos[i][j] = True
            bf(cnt+1,i,j+2)
            pos[i][j] = False


    
    





n, m, h = map(int, input().split())
pos = [[False for j in range(n)] for i in range(h)]
line = [0 for i in range(n)]

for i in range(m):
    a,b = list(map(int, input().split()))
    pos[a-1][b-1] = True
    line[b-1] += 1



ans = 4
bf(0,0,0)
print(ans if ans < 4 else -1)  








