package commerce;

// 고객 관리

public class Customer {

    //속성
    private String customerName; //고객명
    private String customerEmail; // 이메일
    private String customerLevel; // 등급

    //생성자
    public Customer(String customerName, String customerEmail, String customerLevel) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerLevel = customerLevel;
    }


    //기능
    // 1. 고객명을 반환하는 메서드
    public String getCustomerName() {
        return customerName;
    }

    // 2. 이메일 반환 메서드
    public String getCustomerEmail() {
        return customerEmail;
    }

    // 3. 고객등급 반환 메서드
    public String getCustomerLevel() {
        return customerLevel;
    }


}
