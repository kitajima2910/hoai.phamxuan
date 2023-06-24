name = "pham Xuan hoai"

# Chuyển đổi tất cả các ký tự thành chữ thường
name = name.lower()

# Tách tên thành các từ riêng biệt
words = name.split()

# Viết hoa chữ cái đầu tiên của mỗi từ
normalized_words = [word.capitalize() for word in words]

# Ghép các từ lại với nhau
normalized_name = ' '.join(normalized_words)

print("Họ tên chuẩn hóa: ", normalized_name)