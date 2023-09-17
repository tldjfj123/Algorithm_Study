import sys, heapq
input = sys.stdin.readline

def solution() :
    heap = []
    n = int(input())

    for _ in range(n) :
        o = int(input())

        if o == 0 :
            if not heap :
                print(0)
            else :
                print(heapq.heappop(heap))
        else :
            heapq.heappush(heap, o)

solution()