n = int(input("Nhập số nguyên dương n: "))


# Kiểm tra nếu n là số hoàn hảo
def is_perfect_number(n):
    sum_of_divisors = 0
    for i in range(1, n):
        if n % i == 0:
            sum_of_divisors += i
    return sum_of_divisors == n


if n <= 0:
    print("Vui lòng nhập một số nguyên dương.")
else:
    if is_perfect_number(n):
        print(n, "là số hoàn hảo.")
    else:
        print(n, "không phải là số hoàn hảo.")
