package commerce;

// 전체 진행 관리(컨트롤러 역할): 메뉴출력 -> 사용자 입력 받기 (어떤 카테고리? 어떤 기능?) -> Category클래스

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 속성
//    private List<Product> productList; // Product를 관리하는 리스트 -> Category 클래스로 이전
    private Scanner scanner; // Scanner 속성 선언해주기
    private List<Category> categoryList; // Category를 관리하는 리스트


    // 생성자
    public CommerceSystem(List<Category> newCategoryList) {
        this.categoryList = newCategoryList;
        this.scanner = new Scanner(System.in); // Scanner 객체 만들기
    }


    // 기능
    // 1. start 메서드
    public void start() {
        // 카테고리 메뉴 출력
        while (true) {
            int i = 1;
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for (Category category : categoryList) {
                System.out.println(String.format("%d. %s",
                        i,
                        category.getCategory()));
                i++;
            }
            System.out.println(String.format("%d. %-11s | %s", 0, "종료", "프로그램 종료"));

            // 사용자 입력값 받기
            int userChoice = scanner.nextInt();
            if (userChoice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;

                // get(인덱스)로 카테고리 접근
            } else if (userChoice == 1) {
                categoryList.get(userChoice -1);
            } else if (userChoice == 2) {
                categoryList.get(userChoice -1);
            } else if (userChoice == 3) {
                categoryList.get(userChoice -1);
            } else {
                System.out.println("\n입력오류: 번호를 다시 입력하세요.");
            }

        }
    }


}
