package commerce;

// 상품을 카테고리별로 묶어 카테고리 관리

import java.util.List;

public class Category {

    // 속성
    private List<Product> productList; // 카테고리별 productList 인스턴스화함
    private String categoryName; // 카테고리 이름



    // 생성자
    public Category(List<Product> newProductlist, String categoryName) {
        this.productList = newProductlist;
        this.categoryName = categoryName;
    }


    // 기능
    // 1. categoryName 반환 메서드
    public String getCategoryName() {
        return categoryName;
    }

    // 2. productList 반환 메서드
    public List<Product> getProductList() {
        return productList;
    }


}



