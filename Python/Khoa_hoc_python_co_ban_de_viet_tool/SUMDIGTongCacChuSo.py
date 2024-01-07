# Nhập bộ test
T = int(input())

# Tạo list comprehension để tính tổng các chữ số và lưu vào mảng 
totals = [sum(int(num) for num in input()) for _ in range(T)]

# In các giá trị trong totals    
for total in totals:
    print(total)
