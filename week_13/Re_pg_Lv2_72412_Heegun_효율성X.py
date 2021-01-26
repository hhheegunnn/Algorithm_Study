"""https://programmers.co.kr/learn/courses/30/lessons/72412"""

""" 순위 검색 """

# git add week_13/Re_pg_Lv2_72412_Heegun_효율성X.py
# git commit -m "[김희건] pg 순위 검색"

from itertools import product
from bisect import bisect_left, bisect_right

def change_number(ii):
    tmp = []
    k = []
    for i in ii.split():
        if i  == 'cpp' or i == 'backend' or i == 'junior' or i == 'chicken':
            tmp.append([1,0])
        elif i == 'java' or i == 'frontend' or i == 'senior' or i == 'pizza':
            tmp.append([2,0])
        elif i == 'python':
            tmp.append([3,0])
        elif i == 'and':
            continue
        else:
            k.append(int(i))
            

    k.append(list(product(*tmp)))

    return k

def change_q(qq):
    tmp = []
    for q in qq.split():
        if q  == 'cpp' or q == 'backend' or q == 'junior' or q == 'chicken':
            tmp.append(1)
        elif q == 'java' or q == 'frontend' or q == 'senior' or q == 'pizza':
            tmp.append(2)
        elif q == 'python':
            tmp.append(3)
        elif q == 'and':
            continue
        elif q == '-':
            tmp.append(0)
        else:
            tmp.append(int(q))
        
    return tmp

def solution(info,query):

    answer = []

    information = []

    for i in info:
        information.append((change_number(i)))
    
    information.sort(key = lambda x: x[0])
    
    
    for qu in query:
        cnt = 0
        q = change_q(qu)
        q_condition = tuple(q[:-1])
        q_score = q[-1]

        print(q_condition)
        for i in range(bisect_left(information,[q_score]),len(information)):
            if q_condition in information[i][1]:
                cnt += 1

        answer.append(cnt)




    return answer



print(solution(["java backend junior pizza 2900","python frontend senior chicken 210"],["- and - and - and - 150"]))