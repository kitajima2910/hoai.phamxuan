a = float(input("Nhập vào a: "))
b = float(input("Nhập vào b: "))

"""
ax + b = 0
ax + b - b = -b
(ax + b - b) / a = -b / a
"""

if a == 0:
    if b == 0:
        print("Vô số nghiệm.")
    else:
        print("Vô nghiệm")
else:
    x = round(-b / a, 2)
    print("x = ", x)
