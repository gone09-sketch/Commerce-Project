package commerce;

// 커머스 플랫폼의 상품을 관리하고 사용자 입력을 처리하는 클래스

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 속성
    private List<Product> productList; // Product를 관리하는 리스트
    private Scanner scanner; // Scanner 속성 선언해주기


    // 생성자
    public CommerceSystem(List<Product> newProducts) {
        this.productList = newProducts;
        this.scanner = new Scanner(System.in); // Scanner 객체 만들기
    }


    // 기능
    // 1. start 메서드
    public void start() {
        // 상품 메뉴 출력
        while (true) {
            int i = 1;
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for (Product product : productList) {
                System.out.println(String.format("%d. %-12s | %,10d원 | %s",
                        i,
                        product.getProductName(),
                        product.getProductPrice(),
                        product.getProductDescription()));
                i++;
            }
            System.out.println(String.format("%d. %-11s | %s", 0, "종료", "프로그램 종료"));

            // 사용자 입력값 받기
            int userChoice = scanner.nextInt();
            if (userChoice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            } else { // 아직 상품과 관련하여 이동하는 곳을 몰라서 임시로 해둠.
                System.out.println("\n입력오류: 번호를 다시 입력하세요.");
            }
        }
    }


}
