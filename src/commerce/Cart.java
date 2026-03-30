package commerce;

// 장바구니

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // 속성
    private List<Product> cartProducts = new ArrayList<>(); // 장바구니에 넣은 상품들
    private int totalPrice; // 총 주문금액





    // 생성자
    public Cart() {

    }



    // 기능
    // 1. 장바구니 확인 메서드
    public List<Product> getCartProducts() {
        return cartProducts;
    }

    // 2. 주문 취소 메서드
    public void removeCartProduct() {
        cartProducts.remove(int index); // 원하는 장바구니 상품 삭제
    }


}
