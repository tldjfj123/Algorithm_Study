import sys, math
input = sys.stdin.readline

def solution() :
    a, b = map(int, input().split())
    print(math.gcd(a, b))
    print(int(a * b / math.gcd(a, b)))

solution()