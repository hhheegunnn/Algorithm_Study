'''https://www.acmicpc.net/problem/1966'''
'''프린터 큐'''


N = int(input())

for _ in range(N):
    a, b = map(int, input().split())
    nums = list(map(int, input().split()))
    seats = list(range(0,len(nums)))
    answer= 0
    
    for i in range(1000):
        
        if nums[i] < max(nums[i:]):
            
            nums.append(nums[i])
            seats.append(seats[i])
            nums[i] = 0
            seats[i] = ''
            
            continue
        elif seats[i] == b:
            answer += 1
            break
        else:
            
            answer += 1
    
    print(answer)
    
        