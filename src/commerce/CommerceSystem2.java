package commerce;

// 컨트롤러: 흐름제어 (입출력)

import java.util.List;
import java.util.Scanner;

public class CommerceSystem2 {

    // 속성
    private Scanner scanner; // Scanner 속성 선언해주기
    private List<Category> categoryList; // Category를 관리하는 리스트

//    private Category selectedCategory;
//    private Product selectedProduct;
    private Cart cart;


    // 생성자
    public CommerceSystem2(List<Category> newCategoryList, Scanner scanner) {
        this.categoryList = newCategoryList;
        this.scanner = scanner;
        this.cart = new Cart(); // Cart 인스턴스화
    }


    // 기능
    // start 메서드
    public void start() {

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

            // 1-1. 장바구니 주문관리 메뉴 출력(장바구니에 상품이 담겼을 때만)
            if (!cart.isEmpty()) {
                System.out.println("\n[ 주문 관리 ]");
                System.out.println(String.format("%d. %-8s | %s", 4, "장바구니 확인", "장바구니를 확인 후 주문합니다."));
                System.out.println(String.format("%d. %-9s | %s", 5, "주문 취소", "진행중인 주문을 취소합니다."));
            }

            // 2. 사용자 입력값 받기
            int categoryChoice = scanner.nextInt();

            // 3. CategoryList 선택
                // 종료 선택
            if (categoryChoice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break; // 프로그램 종료

                // Category 선택
            } else if (categoryChoice >= 1 && categoryChoice <= categoryList.size()) {
                Category selectedCategory = categoryList.get(categoryChoice - 1);

                // 4. ProductList 출력
                while (true) {
                    int productNumber = 1;
                    System.out.println("[ " + selectedCategory.getCategoryName() + " 카테고리 ]");
                    for (Product product : selectedCategory.getProductList()) {
                        System.out.println(String.format("%d. %-12s | %,10d원 | %s",
                                productNumber,
                                product.getProductName(),
                                product.getProductPrice(),
                                product.getProductDescription()));
                        productNumber++;
                    }
                    System.out.println(String.format("%d. %-11s", 0, "뒤로가기"));

                    // 5. 사용자 입력값 받기
                    int productChoice = scanner.nextInt();

                    // 6. ProductList 선택
                        // 뒤로가기
                    if (productChoice == 0) {
                        break; // [실시간 커머스 플랫폼 메인]으로 돌아감

                        // Product 선택
                    } else if (productChoice >= 1 && productChoice <= selectedCategory.getProductList().size()) {
                        Product selectedProduct = selectedCategory.getProductList().get(productChoice - 1);
                        System.out.println("선택한 상품: " + (String.format("%s | %,d원 | %s | 재고: %d개",
                                selectedProduct.getProductName(),
                                selectedProduct.getProductPrice(),
                                selectedProduct.getProductDescription(),
                                selectedProduct.getProductStock())));
                        System.out.println();

                        // 7. 장바구니 질문 출력
                        System.out.println("\"" + (String.format("%s | %,d원 | %s",
                                selectedProduct.getProductName(),
                                selectedProduct.getProductPrice(),
                                selectedProduct.getProductDescription())) + "\"");
                        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인" + "   " + "2. 취소");

                        // 8. 사용자 입력
                        int cartChoice = scanner.nextInt();

                        // 9. 장바구니 메뉴 선택
                            // 장바구니 추가
                        if (cartChoice == 1) {
                            cart.addProduct(selectedProduct);

                            System.out.println(selectedProduct.getProductName() + "가 장바구니에 추가되었습니다.");
                            System.out.println("아래 메뉴를 선택해주세요. \n");
                            break; // [실시간 커머스 플랫폼] 출력

                            // 주문 취소
                        } else if (cartChoice == 2) {
                            System.out.println("장바구니 추가가 취소되었습니다.");
                            System.out.println("아래 메뉴를 선택해주세요. \n");
                            break; // [실시간 커머스 플랫폼] 출력

                            // 그 외 선택
                        } else {
                            System.out.println("\n입력오류: 번호를 다시 입력하세요.");
                        }

                        // 그 외 선택
                    } else {
                        System.out.println("\n입력오류: 번호를 다시 입력하세요.");
                    }
                }

                // 10. 장바구니 확인하기 및 예외처리
            } else if(categoryChoice == 4) {
                List<CartItem> allCartItems = cart.getCartItemList();
                System.out.println("[ 장바구니 내역 ]");
                System.out.println(allCartItems);


                // 11. 주문 취소하기 및 예외처리
            } else if(categoryChoice == 5) {



                // 그 외 선택
            } else {
                System.out.println("\n입력오류: 번호를 다시 입력하세요.");
            }







        }
    }

}







