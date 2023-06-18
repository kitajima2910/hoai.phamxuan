def is_leap_year(value_year):
    if value_year % 4 == 0 and (value_year % 100 != 0 or value_year % 400 == 0):
        return True
    else:
        return False


year = int(input("Enter a year: "))

if is_leap_year(year):
    print(f"{year} is a leap year.")
else:
    print(f"{year} is not a leap year.")
