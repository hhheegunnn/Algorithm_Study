size = 1
n,m = map(int,input().split())
rec = [list(input()) for _ in range(n)]
for i in range(n-1):
    for j in range(m-1):
        num = rec[i][j]
        for k in range(i+1,n):
            if rec[k][j] == num:
                length = k-i
                if (i+length<n) and (j+length<m):
                    if (rec[i][j+length] == num) and (rec[i+length][j+length]==num):
                        size = max(size,length+1)
                
print(size**2)