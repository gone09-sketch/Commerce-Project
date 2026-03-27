package commerce;

// CommerceSystem클래스에서 관리하던 List<Product>를 이제 이곳에서 관리함
// 상품 조회 (데이터 조회 기능)
// CommerceSystem에서 카테고리가 선택되면 이제 이곳에서 카테고리 조회함

import java.util.List;
import java.util.Scanner;

public class Category {

    // 속성 =(명사다)
    private List<Product> productList; // List<Product> 관리
    private String name; // 카테고리 이름
    private Scanner scanner;


    // 생성자
    public Category(List<Product> newProductlist, String name) {
        this.productList = newProductlist;
        this.name = name;
        this.scanner = new Scanner(System.in);
    }


    // 기능
    // 1. 카테고리 이름을 반환하는 메서드
    public String getName() {
        return name;
    }

    // 상품 메뉴 출력
    public void productsMenu() {
        while (true) {
            int i = 1;
            System.out.println("[ " + this.name + " 카테고리 ]");
            for (Product product : productList) {
                System.out.println(String.format("%d. %-12s | %,10d원 | %s",
                        i,
                        product.getProductName(),
                        product.getProductPrice(),
                        product.getProductDescription()));
                i++;
            }
            System.out.println(String.format("%d. %-11s", 0, "뒤로가기"));

            // 사용자 입력값 받기
            int userChoice = scanner.nextInt();
            if (userChoice == 0) {
                break;
            } else if(userChoice >=1 && userChoice <= productList.size()) {
                Product pickedProduct = productList.get(userChoice -1);
                System.out.println("선택한 상품: " + (String.format("%-12s | %,10d원 | %s | 재고: %d개",
                        pickedProduct.getProductName(),
                        pickedProduct.getProductPrice(),
                        pickedProduct.getProductDescription(),
                        pickedProduct.getProductStock())));
                System.out.println();
                break;
            } else { // 아직 상품과 관련하여 이동하는 곳을 몰라서 임시로 해둠.
                System.out.println("\n입력오류: 번호를 다시 입력하세요.");
            }
        }
    }
}



