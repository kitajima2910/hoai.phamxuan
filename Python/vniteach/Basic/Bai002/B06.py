from Bai002.Library.Main import *

x = float(input_check("Enter x: "))
y = float(input_check("Enter y: "))

result = math.sin(x) / ((2 * x + y) / math.cos(x) - x ** y / (x - y))
print(result)
