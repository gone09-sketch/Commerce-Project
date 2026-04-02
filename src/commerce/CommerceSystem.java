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
    private Cart cart;


    // 생성자
    public CommerceSystem(List<Category> newCategoryList, Scanner scanner) {
        this.categoryList = newCategoryList;
        this.scanner = scanner;
        this.cart = new Cart(); // 비어있는 장바구니 객체 생성
    }


    // 기능
    // start 메서드 (흐름제어)
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


            // 1. 장바구니 추가/취소 출력
            System.out.println("\"" + (String.format("%s | %,d원 | %s",
                    selectedProduct.getProductName(),
                    selectedProduct.getProductPrice(),
                    selectedProduct.getProductDescription())) + "\"");
            System.out.println("위 상품을 장바구니에 추가하시겠습니까?");

            while (true) {
                System.out.println("1. 확인   2. 취소");

                // 2. 사용자 입력값 받기
                int cartChoice = scanner.nextInt();

                // 3. 선택
                if (cartChoice == 1) {
                    cart.addProduct(selectedProduct);
                    System.out.println(selectedProduct.getProductName() + "가 장바구니에 추가되었습니다.");
                    System.out.println("아래 메뉴를 선택해주세요.\n");
                    break;

                } else if (cartChoice == 2) {
                    System.out.println("취소되었습니다.");
                    System.out.println("아래 메뉴를 선택해주세요.\n");
                    break;

                } else {
                    System.out.println("입력오류: 번호를 다시 입력하세요.");
                }
            }


        }
    }

    // display 메서드
    // 메인 메뉴
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


            /* 메서드 분리해주기 */
            // 주문 관리 메뉴 (출력)
            if(!cart.isEmpty()) {
                System.out.println("\n[ 주문 관리 ]");
                System.out.println(String.format("%d. %-9s | %s", 4, "장바구니 확인", "장바구니를 확인 후 주문합니다."));
                System.out.println(String.format("%d. %-10s | %s", 5, "주문 취소", "진행중인 주문을 취소합니다."));
            }
            /* 메서드 분리해주기*/


            // 2. 사용자 입력값 받기
            int categoryChoice = scanner.nextInt();

            // 3. CategoryList 선택
                /* 종료 선택 */
            if (categoryChoice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                return null;

                /* Category 선택 */
            } else if (categoryChoice >= 1 && categoryChoice <= categoryList.size()) {
                Category selectedCategory = categoryList.get(categoryChoice - 1);
                return selectedCategory;


                // 주문 관리 선택  -- 메서드 분리해주기 //
                /* 장바구니 내역 확인*/
            } else if (categoryChoice == 4 && !cart.isEmpty()) {
                int total = 0;
                System.out.println("[ 장바구니 내역 ]");
                for (CartItem item : cart.getCartItemList()) {
                    Product p = item.getProduct();
                    System.out.println((String.format("%s | %,d원 | %s | 수량: %d개",
                            p.getProductName(),
                            p.getProductPrice(),
                            p.getProductDescription(),
                            item.getQuantity())));

                    total += p.getProductPrice() * item.getQuantity();
                }

                /* 총 주문금액 */
                System.out.println("\n[ 총 주문 금액 ]");
                System.out.println(String.format("%,d원", total));

                /* 주문확정 및 메인으로 돌아가기*/
                System.out.println("\n1. 주문 확정     2. 메인으로 돌아가기");
                while (true) {
                    int orderChoice = scanner.nextInt();
                    if (orderChoice == 1) {
                        //주문확정
                        System.out.println("주문이 완료되었습니다! 총 금액: " + String.format("%,d원", total));
                        for (CartItem item : cart.getCartItemList()) {
                            Product p = item.getProduct();
                            /* 기존 재고 - 주문 수량 */
                            int oldStock = p.getProductStock();
                            int newStock = oldStock - item.getQuantity();
                            p.setProductStock(newStock);

                            System.out.println(String.format("%s 재고가 %d개 → %d개로 업데이트되었습니다.",
                                    p.getProductName(),
                                    oldStock,
                                    newStock));
                        }
                        cart.clear(); // 장바구니 리셋
                        System.out.println();
                        break;

                    } else if (orderChoice == 2) {
                        // 메인으로
                        System.out.println("\n메인으로 돌아갑니다.");
                        break;
                    } else {
                        System.out.println("\n입력오류: 번호를 다시 입력하세요.");
                    }
                }

                /* 주문 취소 */
            } else if (categoryChoice == 5 && !cart.isEmpty()) {
                cart.clear();
                System.out.println("진행중인 주문을 취소합니다.");


                /* 그 외 선택 */
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







