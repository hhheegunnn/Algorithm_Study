from sys import stdin


if __name__ == "__main__":
    s = stdin.readline().rstrip()
    reverse = True
    answer = ''
    word = ''
    for c in s:
        if c == '<':
            reverse = False
            answer += word
            word = '<'
        elif c == '>':
            reverse = True
            answer += (word + '>')
            word = ''
        elif c == ' ':
            answer += (word + ' ')
            word = ''
        elif reverse:
            word = c + word
        else:
            word += c

    print(answer + word)