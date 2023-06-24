def remove_numbers(string):
    result = ""
    for char in string:
        if not char.isdigit():
            result += char
    return result


# Nhập xâu từ người dùng
input_string = input("Nhập vào một xâu: ")

# Gọi hàm remove_numbers để loại bỏ các ký tự số
output_string = remove_numbers(input_string)

# Xuất ra màn hình xâu sau khi loại bỏ các ký tự số
print("Xâu sau khi loại bỏ các ký tự số:", output_string)