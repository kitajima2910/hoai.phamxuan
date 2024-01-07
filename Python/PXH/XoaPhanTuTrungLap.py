# Xoá phần tử trùng lặp trong chuỗi

text = 'aaaaddddssssccc'
new_text = ''

for i in text:
    if i not in new_text:
        new_text += i

print(new_text)


# Xoá phần tử trùng lặp trong list
list = [1, 1, 1, 2, 2, 2, 2, 4, 46, 7, 2]
new_list = []

for i in list:
    if i not in new_list:
        new_list.append(i)

print(new_list)