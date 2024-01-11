T = int(input())

def sum_of_divisors(n):
    total = 0
    for i in range(1, n + 1, 1):
        if n % i == 0:
            total += i
    return total

save = []

for i in range(1, T + 1, 1):
    save.append(sum_of_divisors(int(input())))

for i in save: print(i)