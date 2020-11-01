'''https://programmers.co.kr/learn/courses/30/lessons/42883'''
'''큰 수 만들기 '''
'''미완성'''
def solution(number, k):
    number = list(str(number))
    for i in range(len(number)-1):
        
        if k == 0 :
            break
        elif k != 0:
            if int(number[i]) < int(number[i+1]):
                number[i] = 0
                k -= 1
            else: 
                pass
        
        else:
            pass
        
    answernumber = []
    for k in number:
        if k == 0:
            pass
        else:
            answernumber.append(k)
    
    answer = ''
   
    for j in answernumber:
        answer += j
    
    return answer