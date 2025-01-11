from collections import deque

dy = [-1, 0, 0, 1]
dx = [0, -1, 1, 0]

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    q = deque()
    q.append((0, 0, 1))
    maps[0][0] = 0
    while q:
        y, x, k = q.popleft()
        
        if y == n-1 and x == m-1:
            return k
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and maps[ny][nx]:
                maps[ny][nx] = 0
                q.append((ny, nx, k+1))
                
    return -1
    