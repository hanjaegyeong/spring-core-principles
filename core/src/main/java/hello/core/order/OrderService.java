package hello.core.order;

//클라이언트가 주문 생성할때 회원id,상품명,상품가격을 서비스에 파라미터 넘겨줘야하고, 주문 결과 리턴받음
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
