import math

# ax^2 + bx + c = 0

a = float(input("Nhập a: "))
b = float(input("Nhập b: "))
c = float(input("Nhập c: "))

if a == 0:
    if b == 0:
        if c == 0:
            print("Vô số nghiệm.")
        else:
            print("Vô nghiệm.")
    else:
        x = round(-c / b)
        print("x = ", x)
else:
    delta = b**2 - 4*a*c

    if delta > 0:
        x1 = round((-b + math.sqrt(delta)) / (2*a))
        x2 = round((-b - math.sqrt(delta)) / (2*a))
        print("x1 = ", x1)
        print("x2 = ", x2)
    elif delta == 0:
        x = round(-b / (2*a))
        print("x = ", x)
    else:
        print("Vô nghiệm.")
