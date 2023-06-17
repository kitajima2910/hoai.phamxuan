from Bai002.Library.Main import *


g = 9.8


def calculate_free_fall_velocity(height: float):
    return math.sqrt(2 * g * height)


# h = float(input_check("Enter h: "))


print(round(calculate_free_fall_velocity(10), 2), " m/s")
print(round(calculate_free_fall_velocity(5), 2), " m/s")
print(round(calculate_free_fall_velocity(0), 2), " m/s")
print(round(calculate_free_fall_velocity(20), 2), " m/s")
print(round(calculate_free_fall_velocity(15), 2), " m/s")
