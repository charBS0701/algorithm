# N개의 동전을 가지고 있다
# N개의 동전을 이용하여 만들 수 없는 양의 정수 금액 중 최솟값을 구하는 프로그램
# 예를 들어 N=5이고 각 동전이 3원, 2원, 1원, 1원, 9원짜리 동전이라고 하면
# 동빈이가 만들 수 없는 양의 정수 금액 중 최솟값은 8원이다.

n = int(input()) # 동전의 갯수 입력
data = list(map(int,input().split())) # 동전의 종류 입력
data.sort()

target = 1
for x in data:
    # 만들 수 없는 금액을 찾았을 때 반복 종료
    if target < x:
        break
    target += x

# 만들 수 없는 금액 출력
print(target)
