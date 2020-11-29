#https://www.acmicpc.net/problem/10773
N=int(input())
stack=[]
answer=0
for _ in range(N):
    data=int(input())
    if(data!=0):
        stack.append(data)
        answer +=data
    elif not stack:
        pass
    else:
        answer-=stack.pop()
print(answer)
