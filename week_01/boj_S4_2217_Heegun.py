

def solution(n, lost, reserve):
    
    nlist = [1 for i in range(n)]
    
    for r in reserve:
        nlist[r-1] +=1
        
    for l in lost:
        nlist[l-1] -= 1
   
    for k in range(n):
        if nlist[k] == 2:
            if k == n:
                if nlist[k-1] == 0:
                    nlist[k-1] += 1
                    
                else:
                    pass
            elif k == 0:
                if nlist[k+1] == 0:
                    nlist[k+1] += 1
                else:
                    pass
                
            else:
                if nlist[k-1] == 0:
                    nlist[k-1] += 1
                
                    continue
                elif nlist[k+1] == 0:
                    nlist[k+1] += 1
                else :
                    pass
                
        else :
            pass
                
                
        
        
    answer = 0
    for a in nlist:
        if a == 0:
            pass
        else :
            answer += 1
    print(nlist)
    return answer
solution(5, [2,4], [1,3,5])