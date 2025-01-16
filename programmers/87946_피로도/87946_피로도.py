import sys
sys.setrecursionlimit(10**6)

d = []
visited = []

def dp(ddx, k):
    global visited
    ans = [0]
    for i in range(len(d)):
        req, cost = d[i][0], d[i][1]
        if req <= k and not visited[i]: # 최소 피로도 ok
            visited[i] = True
            ans.append(dp(i, k-cost) + 1) # 피로도 소모
            visited[i] = False
        
    return max(ans)

def solution(k, dungeons):
    global d, visited
    d = dungeons
    visited = [False for _ in range(len(d))]
    ans = [0]
    for i in range(len(d)):
        if d[i][0] <= k and not visited[i]: # 최소 피로도 ok
            visited[i] = True
            ans.append(dp(i, k-d[i][1]) + 1) # 피로도 소모
            visited[i] = False
    
    return max(ans)