package commerce;

import java.util.ArrayList;
import java.util.List;

// 프로그램 시작 담당
// Product, Category 객체 생성 + List 추가
// CommerceSystem start 함수 호출

public class Main {
    public static void main(String[] args) {

        // Product 인스턴스화
        Product product1 = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 300);
        Product product2 = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 200);
        Product product3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 150);
        Product product4 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 100);

        // 전자제품 List 선언
        List<Product> electronicsProducts = new ArrayList<>();
        List<Product> clothesProducts = new ArrayList<>();
        List<Product> foodProducts = new ArrayList<>();
        // 전자제품 상품 추가
        electronicsProducts.add(product1);
        electronicsProducts.add(product2);
        electronicsProducts.add(product3);
        electronicsProducts.add(product4);

        // Category 인스턴스화
        Category electronicsCategory = new Category(electronicsProducts, "전자제품");
        Category clothesCategory = new Category(clothesProducts, "의류");
        Category foodCategory = new Category(foodProducts, "식품");


        // List 선언
        List<Category> allCategories = new ArrayList<>();
        // 카테고리 추가
        allCategories.add(electronicsCategory);
        allCategories.add(clothesCategory);
        allCategories.add(foodCategory);

        // CommerceSystem에 카테고리 전달
        CommerceSystem system = new CommerceSystem(allCategories);
        // 카테고리 메뉴 출력 start 메서드 호출
        system.start();
    }
}
