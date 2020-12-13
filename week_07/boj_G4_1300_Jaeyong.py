N = int(input())
K = int(input())
 
low = 0
high = K
answer = 0
while low <= high:
    mid = (low + high)//2
    count = 0
    for i in range (1, N+1):
        count = count + min(mid//i, N)
 
    if count < K:
        low = mid + 1
    else:
        answer = mid
        high = mid - 1
 
print(answer)
