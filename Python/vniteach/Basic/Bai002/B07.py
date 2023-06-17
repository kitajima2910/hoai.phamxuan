from Bai002.Library.Main import *

a, b = map(float, input('Mời nhập toạ độ I: ', 'f').split())
r = float(input('Mời nhập bán kính R: '))
x, y = map(float, input('Mời nhập tọa độ điểm M: ').split())

# Khoảng cách từ điểm I đến điểm M
d = the_distance_from_point_i_to_point_m(x, y, a, b)

if d < r:
    print('Điểm M nằm trong đường tròn')
elif d == r:
    print('Điểm M nằm trên đường tròn')
else:
    print('Điểm M nằm ngoài đường tròn')
