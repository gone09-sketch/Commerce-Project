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
    // 1. 카테고리 이름을 반환하는 메서드
    public String getCategoryName() {
        return categoryName;
    }

    // 2. 선택된 카테고리 출력
    public void printCategory() {
        while (true) {
            int productNumber = 1;
            System.out.println("[ " + this.categoryName + " 카테고리 ]");
            for (Product product : productList) {
                System.out.println(String.format("%d. %-12s | %,10d원 | %s",
                        productNumber,
                        product.getProductName(),
                        product.getProductPrice(),
                        product.getProductDescription()));
                productNumber++;
            }
            System.out.println(String.format("%d. %-11s", 0, "뒤로가기"));
            break;
        }
    }

    // 3. productList 개수 반환 메서드
    public int getProductListCount() {
        return productList.size();
    }

    // 4. productList의 상품 1개를 반환하는 메서드
    public Product getProduct(int index) {
        return productList.get(index);
    }


}



