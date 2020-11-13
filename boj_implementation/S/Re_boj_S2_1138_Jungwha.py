N = int(input())
lines = [0]*(N+1)
arr = list(map(int,input().split()))

cnt = 0
for i in range(N):
  if arr[i] == 0: 
    for j in range(1,N+1):
      if lines[j] == 0:
        lines[j] = i+1
        break
  else: 
    cnt = arr[i]
    for j in range(1,N+1):
      if lines[j] == 0 and cnt == 0:
        lines[j] = i+1
        break
      elif lines[j] == 0 and cnt != 0:
        cnt -= 1
      else:
        continue

for j in range(1,N+1):
  print(lines[j],end=' ')