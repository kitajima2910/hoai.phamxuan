import time

sec = 2

def draw01(n):
  time.sleep(sec)
  count = n // 2
  limit = count + 1

  for i in range(1, n + 1):
      for j in range(1, n + 1):
          if (i < limit and j >= limit and j <= i + limit - 1) or (i == limit and j <= n) or (i > limit and j <= count):
              print("* ", end="")
          else:
              print("  ", end="")
      if i > limit:
          count -= 1
      print()


def draw02(n):
  time.sleep(sec)
  count = n // 2
  limit = count + 1

  for i in range(1, n + 1):
      for j in range(1, n + 1):
          if (i < limit and (j == i + limit - 1 or j == limit)) or (i == limit and j <= n) or (i > limit and (j == 1 or j == count)):
              print("* ", end="")
          else:
              print("  ", end="")
      if i > limit:
          count -= 1
      print()


def draw03(n):
  time.sleep(sec)
  countTop = n
  count = n // 2
  limit = count + 1
  countDown = count

  for i in range(1, n + 1):
      for j in range(1, n + 1):
          if (i < limit and j >= limit and j <= countTop) or (i == limit and j == limit) or (i > limit and j <= limit and j >= countDown):
              print("* ", end="")
          else:
              print("  ", end="")
      if i < limit:
          countTop -= 1
      if i > limit:
          countDown -= 1
      print()


def draw04(n):
  time.sleep(sec)
  countTop = n
  count = n // 2
  limit = count + 1
  countDown = count

  for i in range(1, n + 1):
      for j in range(1, n + 1):
          if (i < limit and (j == limit or j == countTop or (i == 1 and j >= limit))) or (i == limit and j == limit) or (i > limit and (j == limit or j == countDown or i == n and j <= limit)):
              print("* ", end="")
          else:
              print("  ", end="")
      if i < limit:
          countTop -= 1
      if i > limit:
          countDown -= 1
      print()


n = 9
print(f"Vẽ các hình với n = {n}")
draw01(n)
draw02(n)
draw03(n)
draw04(n)