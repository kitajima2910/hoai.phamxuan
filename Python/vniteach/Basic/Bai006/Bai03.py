# Viết chương trình nhập vào mảng gồm n số nguyên dương, hãy xuất ra màn hình tổng của các số lẻ trong mảng đó, với n>2

a = [1, 4, 3, 11]

resultMax = 0

for i in range(0, 4):
    if a[i] % 2 == 1:
        resultMax += a[i]

print(f"Tổng: {resultMax}", end="")
