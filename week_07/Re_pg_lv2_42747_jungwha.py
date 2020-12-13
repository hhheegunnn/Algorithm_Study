def solution(citations):
   
  
    Hlist = []
    for i in range(len(citations)):
            
        H = min(citations[i], i+1)
        Hlist.append(H)
            
    return max(Hlist)