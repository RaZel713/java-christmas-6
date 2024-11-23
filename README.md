# 우아한테크코스 7기 모의 코딩 테스트 - 크리스마스

우아한테크코스 7기 모의 코딩 테스트, 크리스마스를 구현한 저장소입니다.

# 프로그래밍 요구 사항

- [x] JDK 21 버전에서 실행 가능해야 한다.
- [x] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [x] 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 요구사항에서 명시하지 않는 한 파일, 패키지의 이름을 바꾸거나 이동하지 않는다.

- [x] JUnit 5와 AssertJ를 이용하여구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- [x] 입출력을 담당하는 클래스를 별도로 구현한다.
- [ ] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- [ ] 함수(또는 메서드)가 한 가지 일만 잘 하도록 최대한 작게 구현한다.

- [ ] indent(인덴트, 들여쓰기) depth는 2까지만 허용한다. 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] else 예약어와 switch/case 는 허용하지 않는다.
- [ ] Java Enum을 적용하여 프로그램을 구현한다.

## 패키지 목록

```
마지막에 패키지 목록 작성
```

## 기능 목록

### 메뉴

```
<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
```

### 1. 식당 예상 방문 날짜 입력:

- 요구사항) 방문할 날짜는 1 이상 31 이하의 숫자로만 입력받아 주세요.
- 요구사항) 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

- **입력예시**:

```입력예시
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
26
```

<details>
<summary>**토글) 기능 NO.1 유효성 검사**</summary>

> - 입력이 null 이거나 빈 문자열이거나 공백으로만 이루어진 경우
>
> - 1 이상 31 이하의 숫자가 아닌 경우

</details>

---

### 기능 2. 주문 메뉴 입력 구현:

- 요구사항) 음료만 주문 시, 주문할 수 없습니다.
- 요구사항) 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.  
  (e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)
- 요구사항) 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

- **입력예시**:

```입력예시
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
타파스-1,제로콜라-1 
```

<details>
<summary>**토글) 기능 NO.2 유효성 검사**</summary>

> - 고객이 메뉴판에 없는 메뉴를 입력하는 경우
>
> - 메뉴의 개수가 1 이상의 숫자가 아닌 경우
>
> - 메뉴의 총 개수가 20 초과인 경우
>
> - 메뉴 형식이 예시와 다른 경우
>
> - 중복 메뉴를 입력한 경우 (e.g. 시저샐러드-1,시저샐러드-1)
>
> - 음료만 주문했을 경우

</details>

---

### 3. 크리스마스 디데이 할인 적용:

- 요구사항) 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
- 요구사항) 중복된 할인과 증정을 허용한다.
- 요구사항) 이벤트 기간: 2023.12.1 ~ 2023.12.25
- 요구사항) 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가한다.
- 요구사항) 총주문 금액에서 해당 금액만큼 할인한다.
  (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)

---

### 4. 날짜 할인 적용:

- 요구사항) 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
- 요구사항) 중복된 할인과 증정을 허용한다.
- 요구사항) '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용
- 요구사항) 평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
- 요구사항) 주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인

---

### 5. 특별 할인 적용:

- 요구사항) 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
- 요구사항) 중복된 할인과 증정을 허용한다.
- 요구사항) 특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인 (3, 10, 17, 24, 25, 31)

---

### 6. 증정 이벤트 적용:

- 요구사항) 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
- 요구사항) 중복된 할인과 증정을 허용한다.
- 요구사항) 증정 이벤트: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정

---

### 7. 이벤트 뱃지 적용:

- 요구사항) 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
- 요구사항) 중복된 할인과 증정을 허용한다.
- 요구사항) 총혜택 금액에 따라 다른 이벤트 배지를 부여합니다.
    - 5천 원 이상: 별
    - 1만 원 이상: 트리
    - 2만 원 이상: 산타

---

### 8. 이벤트 플래너 내용 출력:

- 요구사항) 주문 메뉴의 출력 순서는 자유롭게 출력해 주세요.
- 요구사항) 총혜택 금액에 따라 이벤트 배지의 이름을 다르게 보여 주세요.
- 요구사항) 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
- 요구사항) 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
- 요구사항) 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 보여 주세요.
- 요구사항) 고객에게 적용된 이벤트 내역만 보여 주세요.
- 요구사항) 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여 주세요.
- 요구사항) 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력해주세요.
- 요구사항) 이벤트 배지가 부여되지 않는 경우, "없음"으로 보여 주세요.
- 요구사항) 주문 메뉴, 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 12월 이벤트 배지 내용을 출력한다.

- **출력예시**:

```출력예시
12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
타파스 1개
제로콜라 1개

<할인 전 총주문 금액>
8,500원
 
<증정 메뉴>
없음
 
<혜택 내역>
없음
 
<총혜택 금액>
0원
 
<할인 후 예상 결제 금액>
8,500원
 
<12월 이벤트 배지>
없음
```

---

## 예외 처리

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
- 사용자가 잘못된 값을 입력했을 때, "[ERROR]"로 시작하는 오류 메시지와 함께 상황에 맞는 안내를 출력한다.

- 1 이상 31 이하의 숫자가 아닌 경우, `[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.`
- 고객이 메뉴판에 없는 메뉴를 입력하는 경우, `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`
- 메뉴의 개수는 1 이상의 숫자만 입력되도록 해주세요. 이외의 입력값은 `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`
- 메뉴 형식이 예시와 다른 경우, `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`
- 중복 메뉴를 입력한 경우(e.g. 시저샐러드-1,시저샐러드-1), `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`

- 또다른 예시

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액>
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
<12월 이벤트 배지>
산타
```