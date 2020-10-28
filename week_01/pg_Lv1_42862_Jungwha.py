"""https://programmers.co.kr/learn/courses/30/lessons/42862"""
"""체육복"""

def solution(n, lost, reserve):
    
    nlist = [1 for i in range(n)] #체육복이 모두 1개씩 있다고 가정
    
    for r in reserve: #reserve목록에 있는 번호는 여벌의 체육복
        nlist[r-1] +=1
        
    for l in lost:#lost목록에 있는 번호는 체육복 -1
        nlist[l-1] -= 1
   
    for k in range(n):
        if nlist[k] == 2: #여벌의 체육복이 있는 학생이
            if k == n: #만약 끝번호이면
                continue #맨밑의 else문을 실행하면 nlist[k+1]에서 nlist 범위를 넘어가 오류가 나므로 continue
                if nlist[k-1] == 0: #앞번호가 체육복이 없다면
                    nlist[k-1] += 1 #앞번호에게 체육복 줌 
                    
                else: #앞번호 체육복 있다면
                    pass #그냥 넘어감
            elif k == 0: #만약 첫번호이면
                
                continue #위와 같은 이유
                if nlist[k+1] == 0: #뒷번호가 체육복이 없다면
                    nlist[k+1] += 1 #뒷번호에게 체육복 줌
                    
                else: #있다면
                    pass #넘어감
                
            else:#첫번째, 마지막 번호가 아닌 경우
                if nlist[k-1] == 0: 
                    nlist[k-1] += 1
                
                    continue #이미 앞번호에게 체육복을 줬다면, 뒷번호에게 줄 수 없다
                elif nlist[k+1] == 0:
                    nlist[k+1] += 1
                else :
                    pass
                
        else : #여벌의 체육복이 없다면
            pass #넘어감
                
                
        
        
    answer = 0
    for a in nlist:
        if a == 0: #체육복이 0개면 참여불가
            pass
        else : #체육복이 1개 이상이면 참여가능
            answer += 1
    
    return answer