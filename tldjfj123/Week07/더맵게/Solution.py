import heapq

def solution(scoville, K):
    heapq.heapify(scoville)

    res = 0
    while 1:
        if scoville[0] >= K :
            return res
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville) * 2

        heapq.heappush(scoville, first + second)
        res += 1