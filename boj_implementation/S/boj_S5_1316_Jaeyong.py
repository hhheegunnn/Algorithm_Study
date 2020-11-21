N = int(input())
count = 0
lst = []
store_char = []
cmp_char = ''
for cnt in range(N):
    lst.append(input())
for string_ in lst:
    for char in string_:
        if (cmp_char != char):
            cmp_char = char
            store_char.append(char)
    if (len(set(store_char)) == len(store_char)):
        count += 1
    store_char = []
    cmp_char = ''
print(count)