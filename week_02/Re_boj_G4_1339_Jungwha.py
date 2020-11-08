'''https://www.acmicpc.net/problem/1339'''
'''단어수학'''



N = int(input())
wordlist = []
for _ in range(N):
    wordlist.append(input())
dic = {}
for word in wordlist:
    k = 0
    for i in word:
        if i not in dic:
            dic[i] = 10**(len(word)- k-1)
        else:
            dic[i] += 10**(len(word)-k-1)
        k +=1
diclist = sorted(list(dic.values()), reverse = True)
answer = 0
for i in range(len(diclist)):
    answer += diclist[i] *(9-i)
print(answer)


