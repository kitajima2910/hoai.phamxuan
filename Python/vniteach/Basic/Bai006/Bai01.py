# Viết chương trình nhập vào dãy các số nguyên bất kỳ, xuất ra màn hình tổng của các số trong dãy đó?
n = int(input("Nhập vào số nguyên n: "))

a = []

# Nhập phần tử vào mảng
for i in range(0, n):
    print(f"Phần tử vị trí {i}: ", end="")
    a.append(int(input()))


result = 0

# Xuất phần tử từ mảng
print(f"\nCác phần tử: ", end="")
for i in range(0, n):
    print(f"{a[i]} ", end="")
    result += a[i]

print(f"\nTổng các phần tử: {result}")
