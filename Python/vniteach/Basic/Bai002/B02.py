from Bai002.Library.Main import *


while True:
    m = int(input_check("Enter m: ", "i"))
    n = int(input_check("Enter n: ", "i"))

    if m > n:
        print("Phần nguyên: ", int(m / n), " - Phần dư: ", m % n)
        break

    print("m < n ? Please again!")
