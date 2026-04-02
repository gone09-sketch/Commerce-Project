package commerce;

 // 장바구니 전체 관리
// 장바구니 리스트 확인/삭제, 총 금액 계산

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // 속성
    private List<CartItem> cartItemList; // 장바구니에 넣은 Item(상품&수량)List
    private int totalPrice; // 총 주문금액


    // 생성자
    /* 비어있는 장바구니로 시작*/
    public Cart() {
        this.cartItemList = new ArrayList<>(); // cartItemList 넣을 공간 만들어주기 (ArrayList 객체 생성)
    }

    /* 외부에서 장바구니 받을 경우*/
    public Cart(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }



    // 기능
    // 1. 장바구니 추가 메서드
    /* Cart -> cartItemList 하나씩 확인
     * CartItem -> Product 꺼내기
     * Product -> 같은 상품이 있는가 확인
        * 있으면 CartItem에서 수량 증가 => addQuantity()
        * 없으면 CartItem에서 => new CartItem()
     */
    public void addProduct(Product product) {
        // 1. cartItemList에서 item하나씩 확인
        for (CartItem item : cartItemList) {
            // 2. 같은 상품이 있는지 확인
            if (item.getProduct().isSameProduct(product)) {
                // 3. 있으면 수량 증가
                item.addQuantity(1);
                return; // 종료
            }
        }
        // 4. 없으면 추가
        CartItem newItem = new CartItem(product,1);
        cartItemList.add(newItem);
    }

    // 2. 장바구니 비었는지 알 수 있는 메서드
    public boolean isEmpty() {
        return cartItemList.isEmpty();
    }

    // 3. 장바구니 주문 취소 시, 삭제 메서드
    public void clear() {
        cartItemList.clear();
    }

    // 3. 장바구니 내역 메서드
    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    // 4. 총 주문 금액 메서드





}
