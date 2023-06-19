def count_primes(n):
    primes = [True] * (n + 1)
    primes[0] = primes[1] = False
    p = 2
    while p * p <= n:
        if primes[p] == True:
            for i in range(p * p, n + 1, p):
                primes[i] = False
        p += 1
    count = sum(primes)
    return count


n = int(input("Nhập số nguyên dương n: "))

count = count_primes(n)

print("Số lượng số nguyên tố nhỏ hơn", n, "là:", count)
