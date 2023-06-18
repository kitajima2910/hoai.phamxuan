while True:

    n = int(input("Nhập số dương n: "))

    if n >= 0:
        break

    print(n, " là số âm.")

if n == 0:
    print(n, " là số chẵn giữa âm và dương")
    exit()

if n % 2 == 1:
    print(n, " là số lẻ.")
else:
    print(n, " là số chẵn.")
