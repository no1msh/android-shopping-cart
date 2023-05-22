# android-shopping-cart

## 기능 요구 사항

### 1단계: 상품목록

#### 사용자는 상품 목록의 상품을 장바구니에 추가할 수 있다.

- 상품을 클릭하면 상품 상세로 이동한다.
- 상품 상세에서 장바구니에 상품을 담을 수 있다.
- 장바구니에서 원하는 상품을 삭제할 수 있다.
- 최근 본 상품이 있는 경우 상품 목록 상단에서 10개까지 확인할 수 있다.
- 앱이 종료돼도 최근 본 상품 목록과 장바구니 데이터는 유지돼야 한다.

### 2단계: 데이터 로딩

#### 목록 뷰에 데이터 로딩 전략을 적용한다.

- 상품 목록에서 더보기 버튼을 눌러 추가 로드할 수 있다. (20개 기준)
- 장바구니 목록은 페이지네이션이 되어야 한다. (5개 기준)

### 3단계: 상태 관리

- 상품 목록에서 장바구니에 담을 상품의 수를 선택 할 수 있다. (B마트 UX 참고)
  - `+` 버튼을 누르면 장바구니에 상품이 추가됨과 동시에 수량 선택 버튼이 노출된다.
  - 상품 목록의 상품 수가 변화하면 장바구니에도 반영되어야 한다.
  - 장바구니의 상품 수가 변화하면 상품 목록에도 반영되어야 한다.
- 장바구니 화면에서 체크박스로 주문할 상품 범위를 조정할 수 있다.
- 전체 체크박스를 선택하면 해당 페이지 내의 상품들만 선택된다.
- 페이지가 바뀌어도 선택된 항목은 유지된다.
- 마지막으로 본 상품 1개를 상품 상세 페이지에서 확인할 수 있다.
- 마지막으로 본 상품을 선택했을 때는 마지막으로 본 상품이 보이지 않는다.
- 마지막으로 본 상품 페이지에서 뒤로 가기를 하면 상품 목록으로 이동한다.

---

## View 기능 목록

### 상품 목록 화면

- [x] 수직 2열 형태로 상품 표시
- [x] 앱바의 제목은 `Shopping`
- [x] 앱바에 장바구니 아이콘이 있고 클릭하면 장바구니로 이동
- [x] 앱바에 장바구니 아이콘옆에 현재 장바구니에 담긴 상품 종류의 개수를 표시
- [x] 상품 아이템은 이름이 길 경우 ...으로 줄여서 표시
- [x] 상품 아이템의 `+` 버튼을 클릭하면 초기값이 1인 수량 조절 표시
  - [x] 이 때 표시된 수량은 장바구니 내의 동일 상품의 개수와 같다.

#### 최근 본 상품이 있을 경우

- [x] 한번이라도 상품 상세 화면으로 이동하면 해당 상품은 최근 본 상품으로 표시
- [x] 최근 본 상품은 상품목록 화면 상단에 수평 리사이클러뷰로 표시
  - [ ] 최근 본 상품이 없을 경우 표시하지 않는다.

### 장바구니 화면

- [x] 앱바의 제목이 Cart
- [x] 수직 1열 형태의 리사이클러뷰로 상품 표시
  - [x] 5개씩 표시, 페이지로 구분
- [x] 아이템의 구성은 상품명, 상품이미지, 가격, x버튼, 수량조절 버튼
- [x] 뒤로가기 버튼
- [x] 전체 체크박스를 선택하면 해당 페이지 내의 모든 상품 선택
- [x] 다른 페이지로 이동해도 선택된 상품은 유지
- [x] 주문하기 버튼에 장바구니에 담은 상품의 종류가 표시
- [x] 선택된 상품의 가격 총합이 표시
- [x] 각 상품의 +, - 버튼으로 수량 조절 표시

### 상품 상세 화면

- [x] 앱바 우측위에 x 버튼
- [x] 앱바 제목 없음
- [x] 상품 이미지, 상품명, 가격, 장바구니 담기 버튼
- [ ] 마지막으로 본 상품 표시
  - [ ] 마지막으로 본 상품의 상세화면일 경우 표시하지 않는다.
  - [ ] 마지막으로 본 상품 페이지일 때 뒤로가기를 하면 상품 목록으로 이동
- [ ] 장바구니 담기 버튼을 클릭하면 수량을 조절할 다이얼로그 표시
---

## Domain 기능 목록

### 상품(Product)
- [x] 상품 이미지 Url을 가지고있다.
- [x] 상품명을 가진다.
-[x] 상품가격을 가진다.

### 장바구니 상품(CartProduct)
-[x] 상품을 가진다.
-[x] 개수를 가진다.
-[x] 사용자가 선택했는지 상태를 가진다.

### 페이지 숫자(PageNumber)
-[x] 페이지 숫자는 기본값이 1이다.
-[x] 1이상의 값만 가질 수 있다.
-[x] 페이지 숫자를 정할 수 있다.

### 가격(Price)
-[x] 최소가격 이상이어야한다.
-[x] 덧셈이 가능하다.
-[x] 곱셈이 가능하다

### 장바구니(Cart)

- [x] 장바구니 상품들을 가지고 있는다.
- [x] 다른 장바구니를 한번에 모두 추가할 수 있다.
- [x] 다른 상품들을 한번에 추가할 수 있다.
- [x] 장바구니의 상품을 제거할 수 있다.
- [x] 장바구니의 상품에서 다른 장바구니 상품들을 한번에 제거할 수 있다.
- [x] 장바구니가 가진 상품의 개수를 바꿀 수 있다
- [x] 장바구니의 상품들 중 선택된 상품의 총합을 계산한다.
- [x] 장바구니의 상품을 골라 선택 상태를 바꿀 수 있다.
- [x] 장바구니의 선택된 상품의 개수를 반환한다.

### 최근 본 상품(RecentProduct)
-[x] 상품을 본 시간을 가진다.
-[x] 상품을 가진다.
