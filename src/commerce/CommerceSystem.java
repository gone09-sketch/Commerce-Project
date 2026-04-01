package commerce;

// 컨트롤러: 흐름제어 (입출력)

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 속성
    private Scanner scanner; // Scanner 속성 선언해주기
    private List<Category> categoryList; // Category를 관리하는 리스트

    private Category selectedCategory;
    private Product selectedProduct;


    // 생성자
    public CommerceSystem(List<Category> newCategoryList, Scanner scanner) {
        this.categoryList = newCategoryList;
        this.scanner = scanner; // Scanner 객체 만들기
    }


    // 기능
    // start 메서드
    public void start() {

        while (true) {

            this.selectedCategory = displayCategory();
            // 프로그램 종료
            if (this.selectedCategory == null) {
                break;
            }

            this.selectedProduct = displayProduct(this.selectedCategory);
            // 뒤로가기
            if (this.selectedProduct == null) {
                continue;
            }

        }
    }

    // display
    public Category displayCategory() {
        while (true) {
            // 1. CategoryList 출력
            int categoryNumber = 1;
            System.out.println("[ 실시간 커머스 플랫폼 메인]");
            for (Category category : categoryList) {
                System.out.println(String.format("%d. %s",
                        categoryNumber,
                        category.getCategoryName()));
                categoryNumber++;
            }
            System.out.println(String.format("%d. %-11s | %s", 0, "종료", "프로그램 종료"));

            // 2. 사용자 입력값 받기
            int categoryChoice = scanner.nextInt();

            // 3. CategoryList 선택
            // 종료 선택
            if (categoryChoice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                return null;

                // Category 선택
            } else if (categoryChoice >= 1 && categoryChoice <= categoryList.size()) {
                Category selectedCategory = categoryList.get(categoryChoice - 1);
                return selectedCategory;

                // 그 외 선택
            } else {
                System.out.println("\n입력오류: 번호를 다시 입력하세요.");
            }
        }
    }
    public Product displayProduct(Category category) {
        // 1. productList 출력
        while (true) {
            int productNumber = 1;
            System.out.println("[ " + category.getCategoryName() + " 카테고리 ]");
            List<Product> productList = category.getProductList();
            for (Product product : productList) {
                System.out.println(String.format("%d. %-12s | %,10d원 | %s",
                        productNumber,
                        product.getProductName(),
                        product.getProductPrice(),
                        product.getProductDescription()));
                productNumber++;
            }
            System.out.println(String.format("%d. %-11s", 0, "뒤로가기"));

            // 2. 사용자 입력값 받기
            int productChoice = scanner.nextInt();

            // productList 선택
            if (productChoice == 0) {
                return null; // 뒤로 가기

            } else if (productChoice >= 1 && productChoice <= productList.size()) {
                Product selectedProduct = productList.get(productChoice - 1);
                System.out.println("선택한 상품: " + (String.format("%s | %,d원 | %s | 재고: %d개",
                        selectedProduct.getProductName(),
                        selectedProduct.getProductPrice(),
                        selectedProduct.getProductDescription(),
                        selectedProduct.getProductStock())));
                System.out.println();
                return selectedProduct;

            } else {
                System.out.println("\n입력오류: 번호를 다시 입력하세요.");
            }
        }
    }


}







