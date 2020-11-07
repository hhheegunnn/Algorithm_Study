def solution(people, limit):
    N = 0
    people.sort()
    people.reverse()
    for i in range(len(people)-1):
        if people[i] == 0:
            continue
        elif (people[i]+people[i+1])/2 > limit:
            pass
        else:
            people[i] = 0
            people[i+1] = 0
            N+= 1
    for k in people:
        if k == 0:
            pass
        else:
            N+=1
            
    print(people)
    return N