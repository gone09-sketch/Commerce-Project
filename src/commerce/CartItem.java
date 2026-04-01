package commerce;

// 장바구니에 추가한 Item(상품+수량) 관리

public class CartItem {

    // 속성
    private Product product; //Product에 있는 상품정보 전체 (참조)
    private int quantity; // 장바구니에 담는 수량


    // 생성자
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }


    // 기능
    // 장바구니 상품추가 수량 (누적값) 메서드
    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

    // Product 반환 메서드
    public Product getProduct() {
        return product;
    }
}
