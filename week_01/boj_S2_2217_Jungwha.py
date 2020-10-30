N = int(input())
ropes = []
for i in range(N):
    ropes.append(int(input()))
ropes.sort()
w = []
for r in range(len(ropes)):
    w.append(ropes[r] * (N-r))
print(max(w))
 