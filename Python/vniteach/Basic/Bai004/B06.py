def solve_problem():
    count_standing = 0
    count_lying = 0
    count_old = 0

    for num_grass in range(1, 101):
        if num_grass % 5 == 0:
            count_standing += 1
        if num_grass % 3 == 0:
            count_lying += 1
        if num_grass % 15 == 0:
            count_old += 1

    return count_standing, count_lying, count_old


standing, lying, old = solve_problem()

print("Số trâu đứng là:", standing)
print("Số trâu nằm là:", lying)
print("Số trâu già là:", old)
