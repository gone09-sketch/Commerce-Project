package commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Product 인스턴스화
        Product product1 = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 300);
        Product product2 = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 200);
        Product product3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 150);
        Product product4 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 100);

        // List 선언
        List<Product> allProducts = new ArrayList<>();

        // 상품 추가
        allProducts.add(product1);
        allProducts.add(product2);
        allProducts.add(product3);
        allProducts.add(product4);

        // CommerceSystem에 상품리스트 전달
        CommerceSystem system = new CommerceSystem(allProducts);
        // 상품 메뉴 출력 start 메서드 실행
        system.start();




    }
}
