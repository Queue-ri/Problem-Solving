def solution(n):
    ans = 0
    while 0 < n:
        isOdd = n & 1
        n = (n - 1 if isOdd else n // 2)
        ans += isOdd
    
    return ans