N=int(input())
person_lst=[]
rank_lst=[]
for person in range(N):
    person_lst.append(list(map(int,input().split( ))))

for person in range(N):
    rank=1
    for cmp_person in range(N):
        if(person_lst[person][0]<person_lst[cmp_person][0] and person_lst[person][1]<person_lst[cmp_person][1]):
            rank+=1
    rank_lst.append(rank)
    print(rank,end=' ')