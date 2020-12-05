N=int(input())

serial=[]
answer=[]
for _ in range(N):
    serial.append(input())

for string in serial:
    count=0
    for char in string:
        if(char.isdigit()):
            count+=int(char)
    answer.append((len(string),count,string))

answer.sort(key=lambda x:(x[0],x[1],x[2]))

for _ in answer:
    print(_[2])
    
        
        
        
    
