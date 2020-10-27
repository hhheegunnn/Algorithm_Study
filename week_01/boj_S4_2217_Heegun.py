"""https://www.acmicpc.net/problem/2217"""


""" 로프 """

N = int(input())

w_list = list(int(input()) for _ in range(N))

w_list.sort(reverse = True)

possible_weight = 0

for i in range(len(w_list)):
    tmp = w_list[i]*(i+1)
    if possible_weight <= tmp:
        possible_weight = tmp


    

print(possible_weight)

    





