package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //클래스객체. 자바가 실행될 때 한번만 생성

    public static SingletonService getInstance() { //위 인스턴스의 참조를 꺼낼 수 있는 유일한 매서드
        return instance;
    }
    
    private SingletonService() { //생성자를 private로 만들어서 생성하지 못하도록 막음! 즉 생성은 불가, 인스턴스 사용은 가능
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
