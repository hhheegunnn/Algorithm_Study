N = int(input())
w =[]
h =[]
answer = [1 for j in range(N)]
for _ in range(N):
    a,b = map(int, input().split())
    w.append(a)
    h.append(b)
for i in range(N):
    for k in range(N):
        if w[i] < w[k]:
            if h[i] < h[k]:
                answer[i] += 1
answer = map(str, answer)
print(' '.join(answer))
