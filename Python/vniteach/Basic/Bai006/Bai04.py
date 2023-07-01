# Viết chương trình nhập vào số nguyên dương n, xuất ra màn hình các số nguyên tố nhỏ hơn n, với n>2

a = [1, 11, 3, 113, 5, 2]

n = 6

for i in range(0, n):

    if a[i] < 2:
        continue

    flag = True
    for j in range(2, a[i] // 2):
        if a[i] % j == 0:
            flag = False
            break

    if flag and a[i] < n:
        print(f"{a[i]} ", end="")



