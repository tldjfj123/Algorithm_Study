import sys
input = sys.stdin.readline

n = int(input())
papers = []

for _ in range(n):
    row = list(map(int,input().rsplit()))
    papers.append(row)

blue_cnt, white_cnt = 0, 0

def check(row,col,n):
    global blue_cnt, white_cnt

    curr = papers[row][col]
    for i in range(row, row + n):
        for j in range(col, col + n):
            if curr != papers[i][j]:
                next_n = n // 2
                check(row, col, next_n)
                check(row, col + next_n, next_n)
                check(row + next_n, col, next_n)
                check(row + next_n, col + next_n, next_n)
                return
    if curr == 0:
        white_cnt += 1
    else:
        blue_cnt += 1
    return

check(0,0,n)
print(white_cnt)
print(blue_cnt)