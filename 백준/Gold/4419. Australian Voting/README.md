# [Gold IV] Australian Voting - 4419 

[문제 링크](https://www.acmicpc.net/problem/4419) 

### 성능 요약

메모리: 15816 KB, 시간: 156 ms

### 분류

구현, 시뮬레이션

### 제출 일자

2024년 7월 11일 00:13:42

### 문제 설명

<p>Australian ballots require that the voter rank the candidates in order of choice. Initially only the first choices are counted and if one candidate receives more than 50% of the vote, that candidate is elected. If no candidate receives more than 50%, all candidates tied for the lowest number of votes are eliminated. Ballots ranking these candidates first are recounted in favour of their highest ranked candidate who has not been eliminated. This process continues [that is, the lowest candidate is eliminated and each ballot is counted in favour of its ranked non-eliminated candidate] until one candidate receives more than 50% of the vote or until all candidates are tied.</p>

### 입력 

 <p>The first line of input is an integer n <= 20 indicating the number of candidates. The next n lines consist of the names of the candidates in order. Names may be up to 80 characters in length and may contain any printable characters. Up to 1000 lines follow; each contains the contents of a ballot. That is, each contains the numbers from 1 to n in some order. The first number indicates the candidate of first choice; the second number indicates candidate of second choice, and so on.</p>

### 출력 

 <p>The Output consists of either a single line containing the name of the winner or several lines containing the names of the candidates who tied. </p>

