package commerce;

// 컨트롤러: 흐름제어 (입출력)

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 속성
    private Scanner scanner; // Scanner 속성 선언해주기
    private List<Category> categoryList; // Category를 관리하는 리스트


    // 생성자
    public CommerceSystem(List<Category> newCategoryList , Scanner scanner) {
        this.categoryList = newCategoryList;
        this.scanner = scanner; // Scanner 객체 만들기
    }


    // 기능
    // 1. start 메서드
    public void start() {
        // categoryList 출력
        while (true) {
            int categoryNumber = 1;
            System.out.println("[ 실시간 커머스 플랫폼 메인]");
            for (Category category : categoryList) {
                System.out.println(String.format("%d. %s",
                        categoryNumber,
                        category.getCategoryName()));
                categoryNumber++;
            }
            System.out.println(String.format("%d. %-11s | %s", 0, "종료", "프로그램 종료"));

            // [실시간 커머스 플랫폼 메인] 사용자 입력값 받기
            int categoryChoice = scanner.nextInt();
            if (categoryChoice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break; // 프로그램 종료

                // Category 객체 선택
            } else if (categoryChoice >= 1 && categoryChoice <= categoryList.size()) {
                Category selectedCategory = categoryList.get(categoryChoice -1);


                // productList 출력
                while (true) {
                    int productNumber = 1;
                    System.out.println("[ " + selectedCategory.getCategoryName() + " 카테고리 ]");
                    for(Product product : selectedCategory.getProductList()) {
                        System.out.println(String.format("%d. %-12s | %,10d원 | %s",
                                productNumber,
                                product.getProductName(),
                                product.getProductPrice(),
                                product.getProductDescription()));
                        productNumber++;
                    }
                    System.out.println(String.format("%d. %-11s", 0, "뒤로가기"));

                    // [ "  " 카테고리] 사용자 입력값 받기
                    int productChoice = scanner.nextInt();
                    if (productChoice == 0) {
                        break; // [실시간 커머스 플랫폼 메인]으로 돌아감

                        // Product 객체 선택
                    } else if(productChoice >= 1 && productChoice <= selectedCategory.getProductList().size()) {
                        Product selectedProduct = selectedCategory.getProductList().get(productChoice -1);
                        System.out.println("선택한 상품: " + (String.format("%s | %,d원 | %s | 재고: %d개",
                                selectedProduct.getProductName(),
                                selectedProduct.getProductPrice(),
                                selectedProduct.getProductDescription(),
                                selectedProduct.getProductStock())));
                        System.out.println();


                        // 장바구니 질문 출력
                        System.out.println("\"" + (String.format("%s | %,d원 | %s",
                                selectedProduct.getProductName(),
                                selectedProduct.getProductPrice(),
                                selectedProduct.getProductDescription())) + "\"");
                        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인" + "   " + "2. 취소");

                        // 장바구니 선택 사용자 입력
                        int cartChoice = scanner.nextInt();
                        if (cartChoice == 1) {

                            // .add(selectedProduct) 장바구니 추가


                            System.out.println( selectedProduct.getProductName() + "가 장바구니에 추가되었습니다.");
                            System.out.println("아래 메뉴를 선택해주세요. \n");
                            break; // [실시간 커머스 플랫폼 메인]으로 돌아감 + [주문관리]
                        } else if (cartChoice == 2) {
                            System.out.println("장바구니 추가가 취소되었습니다.");
                            System.out.println("아래 메뉴를 선택해주세요. \n");
                            break; // [실시간 커머스 플랫폼 메인]으로 돌아감
                        }

                    } else {
                        System.out.println("\n입력오류: 번호를 다시 입력하세요.");
                    }
                }

            } else {
                System.out.println("\n입력오류: 번호를 다시 입력하세요.");
            }

        }
    }
}
