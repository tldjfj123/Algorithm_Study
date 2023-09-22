import sys
input = sys.stdin.readline
"""
1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
3. 마지막 도착 계단은 반드시 밟아야 한다.
문제의 요점 : 현재 계단에서 이 친구는 -1 계단에서 왔을까 아니면 -2 계단에서 왔을까??
-1 계단에서 온 경우의 점화식 : dp[i-3] + stair[i-1] + stair[i]
-2 계단에서 온 경우의 점화식 : dp[i-2] + stair[i]
"""
def solution() :
    n = int(input())
    stair = [0 for _ in range(n+1)]
    for i in range(1, n+1) :
        stair[i] = int(input())
    dp = [0 for _ in range(n+1)]
    
    if n <= 2 :
        print(sum(stair))
    else :
        dp[1] = stair[1]
        dp[2] = stair[1] + stair[2]
        dp[3] = max(stair[1] + stair[3], stair[2] + stair[3])

        for i in range(4, n+1) :
            dp[i] = max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i])
        print(dp[n])

solution()