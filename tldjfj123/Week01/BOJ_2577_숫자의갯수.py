import sys, collections
ibput = sys.stdin.readline

def solution() :
    a = int(input())
    b = int(input())
    c = int(input())

    res = dict(collections.Counter(str(a * b * c)))  
    for i in range(10) :
        if str(i) not in res.keys() :
            print(0)
        else :
            print(res[str(i)])
    
solution()