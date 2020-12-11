def solution(array, commands):
    answer = []
    for r in commands:
        
        array2 = array[r[0]-1:r[1]]
        array2.sort()
        answer.append(array2[r[2]-1])
        
    return answer