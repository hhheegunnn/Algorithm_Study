N, M = map(int, input().split())
tree = list(map(int, input().split()))
low=0
high=max(tree)-1

while low <= high:
    mid = (low+high) // 2
    
    tree_sum= 0
    for i in tree:
        if (i >= mid):
            tree_sum += i - mid
    
    if(tree_sum >= M):
        low = mid + 1
    else:
        high = mid - 1
print(high)
