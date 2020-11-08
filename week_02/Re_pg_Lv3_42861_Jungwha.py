'''https://programmers.co.kr/learn/courses/30/lessons/42861'''
'''섬 연결하기'''

def solution(n, costs):
    answer = 0
    costs = sorted(costs, key = lambda x : x[2])
    con = set()
    con.add(0)
    while len(con) != n:
        for cost in costs:
            a, b, c = cost
            if a in con or b in con:
                if a in con and b in con:
                    pass
                else:
                    con.add(a)
                    con.add(b)
                    answer += c
                    break
    return answer