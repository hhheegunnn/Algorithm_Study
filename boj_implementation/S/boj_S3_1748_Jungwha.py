N = int(input())
size = len(str(N))
b = 0
for k in range(1,size):
    a = (9 * 10 ** (k-1)) * k
    b += a
less = (N - 10**(size-1) +1) * size    
print( b + less)