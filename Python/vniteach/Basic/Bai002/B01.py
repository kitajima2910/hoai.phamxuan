from Bai002.Library.Main import *


# Kiểm tra chuỗi nhập vào có phải số hay không
C = input_check("Input Celsius: ")

K = celsius_to_kelvin(C)

resultK = str(C) + "°C" + " -> " + str(K) + "K"

print(resultK)
