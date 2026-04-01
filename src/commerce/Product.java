package commerce;

// 상품정보 관리

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

    // 상품재고 변경
    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }


    // 상품명 비교 메서드
    /* 현재 상품(this)와 다른 상품(otherItem)의 상품명이 같은지 비교 */
    public boolean isSameProduct(Product otherItem) {
        return this.productName.equals(otherItem.productName);
    }





}
