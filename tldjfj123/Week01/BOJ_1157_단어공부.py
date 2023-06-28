import sys, collections
input = sys.stdin.readline

def solution() :
    s = input().rstrip().lower()
    res = collections.Counter(s).most_common()

    if len(res) == 1 :
        print(res[0][0].upper())
    else :
        if res[0][1] == res[1][1] :
            print('?')
        else :
            print(res[0][0].upper())

solution()