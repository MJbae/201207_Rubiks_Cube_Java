## Step3 동작방식
### 1. 사용자 입력을 요구사항에 따라 구분
* 사용자 입력에 대해 구분하는 전체 로직은 Step2의 방식과 유사함
* 일반문자(작은따옴표나 뒤에 숫자가 오지 않는 경우)의 경우, Step2의 방식과 동일함
* 작은따옴표 외에도 뒤에 숫자가 붙는 문자의 경우, 작은 따옴표 또는 숫자(2 or 3) 뒤에 공백 추가
### 2. 조작 개수 카운트
* 전역변수(private static) 선언하여 모든 메소드에서 접근 가능하도록 설정
* runRotation 메소드 내 countRotation 메소드에서 각 조작명령에 대해 카운트 실시
* 일반 조작명령의 경우 +1 카운트되지만, 명령 뒤에 2 or 3이 붙는 경우 그만큼 추가로 카운트
* executePrompt 메소드에서 while 순회문 종료 시 전역변수의 결과값을 출력
### 3. 일반문자 뒤에 숫자가 붙는 조작에 대한 처리
* 뒤에 숫자가 붙는 조작명령에 대해 숫자가 붙는 만큼 해당 명령에 대한 실행을 반복함
### 4. 위쪽 or 아래쪽 큐브 회전
* **위쪽면을 시계방향으로 회전할 경우**
* 가. 왼쪽, 오른쪽, 뒤쪽, 앞쪽면의 순서로 rubiksCube의 각각의 첫번째행을 임시 배열에 할당함
* 나. 임시 배열의 각 사이드의 첫번째행을 뒤쪽, 앞쪽, 오른쪽, 왼쪽 순서로 rubiksCube에 할당하여 순서 변경
* **위쪽면을 반시계방향으로 회전할 경우**
* 가. 시계방향으로 회전하는 경우와 같은 방법으로 임시 배열을 조작함
* 나. 임시 배열의 각 사이드의 첫번째행을 앞쪽, 뒤쪽, 왼쪽, 오른쪽 순서로 rubiksCube에 할당하여 순서 변경
* **아래쪽면을 회전하는 경우**
* 아래쪽면을 반시계방향으로 회전하는 경우는 위쪽면을 시계방향으로 회전하는 경우와 유사하나 임시 배열에 첫번째행이 아니라 마지막행을 할당한다는 것이 다름
* 아래쪽면을 시계방향으로 회전하는 경우는 위쪽면을 반시계방향으로 회전하는 경우과 같으며, 마찬가지로 임시 배열에 마지막행을 할당함
### 5. 앞쪽 or 뒤쪽 큐브 회전
* **앞쪽면을 시계방향으로 회전할 경우**
* 가. 왼쪽, 위쪽, 오른쪽, 아래쪽면의 순서로 rubiksCube의 각각의 마지막행을 임시 배열에 할당함
* 나. 임시 배열의 각 사이드의 마지막행을 위쪽, 오른쪽, 아래쪽, 왼쪽 순서로 rubiksCube에 할당하여 순서 변경
* **앞쪽면을 반시계방향으로 회전할 경우**
* 가. 시계방향으로 회전하는 경우와 같은 방법으로 임시 배열을 조작함
* 나. 임시 배열의 각 사이드의 마지막행을 아래쪽, 왼쪽, 위쪽, 오른쪽 순서로 rubiksCube에 할당하여 순서 변경
* **뒤쪽면을 회전하는 경우**
* 뒤쪽면을 반시계방향으로 회전하는 경우는 앞쪽면을 시계방향으로 회전하는 경우와 유사하나 임시 배열에 마지막행이 아니라 첫번째행을 할당
* 뒤쪽면을 시계방향으로 회전하는 경우는 앞쪽면을 반시계방향으로 회전하는 경우과 같으며, 마찬가지로 임시 배열에 첫번째행에 할당
### 6. 오른쪽 or 왼쪽 큐브 회전
* **오른쪽면을 시계방향으로 회전할 경우**
* 가. 앞쪽, 위쪽, 뒤쪽, 아래쪽면의 순서로 rubiksCube의 각각의 마지막열을 임시 배열에 할당함
* 나. 임시 배열의 각 사이드의 마지막열을 위쪽, 뒤쪽, 아래쪽, 앞쪽 순서로 rubiksCube에 할당하여 순서 변경
* **오른쪽면을 반시계방향으로 회전할 경우**
* 가. 시계방향으로 회전하는 경우와 같은 방법으로 임시 배열을 조작함
* 나. 임시 배열의 각 사이드의 마지막열을 아래쪽, 앞쪽, 위쪽, 뒤쪽쪽 순서로 rubiksCube에 할당하여 순서 변경
* **왼쪽면을 회전하는 경우**
* 왼쪽면을 반시계방향으로 회전하는 경우는 오른쪽면을 시계방향으로 회전하는 경우와 유사하나 임시 배열에 마지막열이 아니라 첫번째열을 할당
* 왼쪽면을 시계방향으로 회전하는 경우는 오른쪽면을 반시계방향으로 회전하는 경우과 같으며, 마찬가지로 임시 배열에 첫번째열에 할당

