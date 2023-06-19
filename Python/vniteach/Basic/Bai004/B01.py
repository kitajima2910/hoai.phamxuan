# S = 1 + 2 + 3 + ... + n

# n = int(input("Nhập n: "))


def totalTest(n):

    if n < 0:
        print("Vui lòng nhập lại n >= 0")
        exit()

    S = 0

    for i in range(1, n + 1):
        S += i

    return S


print(totalTest(5))
print(totalTest(10))
print(totalTest(1))
print(totalTest(0))
print(totalTest(-1))
