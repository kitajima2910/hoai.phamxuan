# Viết chương trình nhập vào dãy các số bất kỳ, tìm số lớn nhất trong dãy số đó và xuất ra màn hình?

n = int(input("Nhập vào số nguyên n: "))

a = []

# Nhập phần tử vào mảng
for i in range(0, n):
    print(f"Phần tử vị trí {i}: ", end="")
    a.append(float(input()))

resultMAX = 0

# Xuất phần tử từ mảng
print(f"\nCác phần tử: ", end="")
for i in range(0, n):
    print(f"{a[i]} ", end="")
    if resultMAX < a[i]:
        resultMAX = a[i]

print(f"\nPhần tử lớn nhất: {resultMAX}")
