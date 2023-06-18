def check_triangle_type(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return "Ba cạnh không hợp lệ. Nhập lại các số dương."
    elif a + b <= c or b + c <= a or a + c <= b:
        return "Ba cạnh không tạo thành tam giác."
    elif a == b and b == c:
        return "Tam giác đều."
    elif a == b or b == c or a == c:
        if a*a + b*b == c*c or b*b + c*c == a*a or a*a + c*c == b*b:
            return "Tam giác vuông cân."
        else:
            return "Tam giác cân."
    elif a*a + b*b == c*c or b*b + c*c == a*a or a*a + c*c == b*b:
        return "Tam giác vuông."
    else:
        return "Tam giác thường."


# Example usage
a = float(input("Nhập giá trị cạnh a: "))
b = float(input("Nhập giá trị cạnh b: "))
c = float(input("Nhập giá trị cạnh c: "))

result = check_triangle_type(a, b, c)
print(result)