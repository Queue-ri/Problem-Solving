from itertools import combinations

def solution(number):
    comb = combinations(number, 3)
    ans = 0
    for (a, b, c) in comb:
        if a+b+c == 0: ans += 1
    
    return ans