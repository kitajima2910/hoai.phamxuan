import math


STRING_INCORRECT: str = "The string you entered incorrect."


def celsius_to_kelvin(celsius: float):
    """
    Đổi nhiệt độ C sang nhiệt độ K

    :param celsius: float
    :return: float
    """

    return float(celsius) + 273.15


def check_float(str_input: str):
    """
    Kiểm tra chuỗi có phải là số thực hay không

    :param str_input: str
    :return: bool
    """

    try:
        float(str_input)
    except ValueError:
        return False
    return True


def input_check(content: str, type_number="f"):
    """
    Kiểm tra chuỗi nhập vào

    :param content: str
    :param type_number: str (f -> float, i -> int)
    :return: void
    """
    while True:
        temp = input(content)

        if "f" == type_number.lower() and check_float(temp):
            break

        if "i" == type_number.lower() and temp.isdigit():
            break

        print(STRING_INCORRECT)

    return temp


def calculate_circle_area(r: float):
    """
    Tính diện tích hình tròn: π * bán kính^2

    :param r: float
    :return: float
    """

    return math.pi * r ** 2
