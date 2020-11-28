'''https://www.acmicpc.net/problem/1316'''
'''그룹 단어 체커'''
N = int(input())
a = 1
def solution():
    global word
    global a
    global N
    for i in range(len(word)-1):
        
        if word[i] != word[i+1]:
            newword = word[i+1:]
            if word[i] in newword:
                N-=1
                break
            else:
                pass

    
for _ in range(N):
    word = list(input())
    solution()
print(N)


        