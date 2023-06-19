m = int(input("Nhập số nguyên dương m: "))
n = int(input("Nhập số nguyên dương n: "))

# Kiểm tra m > n
if m <= n:
    print("Vui lòng nhập số nguyên dương m lớn hơn n.")
else:
    # Tìm ước chung lớn nhất (GCD) bằng thuật toán Euclid
    while n != 0:
        temp = n
        n = m % n
        m = temp

    # Tính bội chung nhỏ nhất (LCM) bằng công thức LCM = (m * n) / GCD
    lcm = (m * n) // temp

    # In kết quả
    print("Ước chung lớn nhất của", m, "và", n, "là:", temp)
    print("Bội chung nhỏ nhất của", m, "và", n, "là:", lcm)