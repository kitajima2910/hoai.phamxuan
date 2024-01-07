# Nhập bộ test
T = int(input())

# Xử lý bài toán
for total in [sum(int(num) for num in input()) for _ in range(T)]: print(total)
