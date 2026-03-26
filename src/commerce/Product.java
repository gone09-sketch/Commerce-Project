package commerce;

public class Product {

    // 속성
    // 상품명, 가격, 설명, 재고수량
    private String productName;
    private int productPrice;
    private String productDescription;
    private int productStock;

    //생성자
    public Product(String productName, int productPrice, String productDescription, int productStock) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productStock = productStock;
    }


    //기능

    // 1. getter
    // 상품명
    public String getProductName() {
        return productName;
    }

    // 상품가격
    public int getProductPrice() {
        return productPrice;
    }

    // 상품설명
    public String getProductDescription() {
        return productDescription;
    }

    // 상품재고
    public int getProductStock() {
        return productStock;
    }


}
