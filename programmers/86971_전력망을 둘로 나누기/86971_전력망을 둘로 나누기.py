from collections import deque

def solution(n, wires):
    # 양방향 그래프: idx번 송전탑에 대한 인접 송전탑
    graph = [[] for _ in range(n+1)]
    for w in wires:
        s, t = w
        graph[s].append(t)
        graph[t].append(s)
    
    # 간선 하나 끊어보고 2번 bfs 돌려서 그룹별 송전탑 개수 총합 구하기
    ans = 100
    for w in wires:
        s, t = w
        visited = [False for _ in range(n+1)] # 각 case마다 visited reset
        
        # bfs
        res = [] # 그룹별 송전탑 개수 총합
        for i in range(1, n+1):
            if visited[i]: continue
            
            q = deque()
            q.append(i)
            visited[i] = True

            cnt = 0
            while q:
                cur = q.popleft()
                cnt += 1
                for nxt in graph[cur]:
                    if set([cur, nxt]) != set([s, t]) and not visited[nxt]:
                        visited[nxt] = True
                        q.append(nxt)

            res.append(cnt)
        
        diff = abs(res[0] - res[1])
        ans = min(ans, diff)
                            
    return ans