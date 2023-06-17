strBefor = "asdh238#@$4$#@92"


def count_digits(str_value):
    count = 0
    for char in str_value:
        if char.isdigit():
            count += 1
    return count


print(count_digits(strBefor))
