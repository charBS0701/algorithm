# 시간이 적게 걸리는 음식부터 확인하는 탐욕적 접근방식으로 해결할 수 있다.
# 모든 음식을 시간을 기준으로 정렬한 뒤에 시작이 적게 걸리는 음시부터 제거해 나가는 방식을 이용한다
# 이를 위해 우선순위 큐를 이용하여 구현할 수 있는데 문제를 풀기위해 고려해야 하는 부분이 많아서 까다로울 수 있다.

# 간단한 예시로 다음과 같이 3개의 음식이 있으면 k를 15초라고 하자
## 1번음식 : 8초 소요
## 2번음식 : 6초 소요
## 3번음식 : 4초 소요

#0 초기단계에서는 모든 음식을 우선순위 큐(최소 힙)에 삽입한다.
#  또한 마지막에는 k초 후에 먹어야 할 음식의 번호르 출력해야하므로 우선순위 큐에 삽입할 때 (음식 시간, 음식 번호)의 튜플 형태로 삽입한다.
#1 첫 단계에서는 가장 적게 걸리는 음식인 3번 음식을 뺀다. 다만, 음식이 3개 남아 있으므로 3(남은 음식의 개수) x 4(3번 음식을 먹는 시간) = 12를 빼야한다.
#  다시 말해 3번 음식을 다 먹기 위해서는 12초가 걸린다는 의미이다. 결과적으로 전체 남은 시간이 15초에서 (-12) 3초로 줄어들게 된다.
#2 전체 남은 시간은 3초이고 이번 단계에서는 2번 음식을 빼야한다. 전체 음식이 2개 남아 있으므로 이번 단계에서 뺄 시간은
#  2(남은 음식의 개수) x 2(2번 음식을 다 먹는 시간) = 4초가 된다.
#  하지만 현재 전체 남은 시간이 3초인데 이는 4보다 작으므로 빼지 않도록 한다.
#  따라서 '다음으로 먹어야 할' 음식의 번호를 찾아 출력하면 된다. 다음 그림처럼 매초 먹어야 할 음식들을 일렬로 나열해보자.
#  남은 시간이 3초이므로 4번째 음식의 번호를 출력하면 정답이다.


# 이 코드는 다음 프로그래머스 사이트에서 테스트해야 정상 동작한다.
# https://programmers.co.kr/learn/courses/30/lessons/42891?language=python3

import heapq

def solution(food_times, k):
    # 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
    if sum(food_times) <= k:
        return -1

    # 시간이 작은 음식부터 빼야 하므로 우선순위 큐를 이용
    q = []
    for i in range(len(food_times)):
        # (음식 시간, 음식 번호) 형태로 우선순위 큐에 삽입
        heapq.heappush(q, (food_times[i], i+1))

    sum_value = 0 # 먹기 위해 사용한 시간
    previous = 0 # 직전에 다 먹은 음식 시간
    
    length = len(food_times) # 남은 음식의 개수

    # sum_value + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
    while sum_value + ((q[0][0] - previous) * length) <= k:
        now = heapq.heappop(q)[0]
        sum_value += (now - previous) * length
        length -= 1 # 다 먹은 음식 제외
        previous = now # 이전 음식 시간 재설정

    # 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
    result = sorted(q, key = lambda x: x[1]) # 음식의 번호 기준으로 정렬
    return result[(k-sum_value) % length][1]
