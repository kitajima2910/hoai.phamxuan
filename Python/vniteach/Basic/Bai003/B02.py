a = float(input("Nhập cạnh a: "))
b = float(input("Nhập cạnh b: "))
c = float(input("Nhập cạnh c: "))

if a + b > c and a + c > b and b + c > a:
    print("Là 3 cạnh của tam giác.")
else:
    print("Không là 3 cạnh của tam giác.")
