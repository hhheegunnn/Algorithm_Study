'''https://www.acmicpc.net/problem/4963'''
'''섬의 개수'''
dx = [-1, 1, 0, 0, -1, 1, -1, 1]
dy = [0, 0, -1, 1, -1, 1, 1, -1]


def solution(x, y):
    
    for k in range(8):
        nx = x + dx[k]
        ny = y + dy[k]
        if (0<= nx < a) and (0 <=ny <b):
            print(mapping)
            if mapping[nx][ny] == 1:
            
                mapping[nx][ny] = 0
                solution(nx, ny)
while True:
    answer = 0
    a,b = map(int, input().split())
    if a == 0 and b == 0:
        break
    mapping = []
    for _ in range(b):
        c = list(map(int, input().split()))
        mapping.append(c)
    
    for i in range(b):
        for j in range(a):
            if mapping[i][j] == 1:
                mapping[i][j] = 0
                solution(i,j)
                answer += 1
    print(answer)
        