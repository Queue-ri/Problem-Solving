import sys
input = sys.stdin.readline

def solution(num):
    n = num
    
    if n == 1: return 0
    for i in range(500):
        n = n * 3 + 1 if n & 1 else n // 2
        if n == 1: return i+1
        
    return -1