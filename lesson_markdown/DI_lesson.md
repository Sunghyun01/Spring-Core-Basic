# 다양한 의존관계 주입 방법
의존관계 주입은 크게 4가지 방법이 있다.


1. 생성자 주입
2. 수정자 주입(setter 주입)
3. 필드 주입
4. 일반 메서드 주입
  
  

# 생성자 주입
생성자 호출시점에 딱 1번만 호출되는 것이 보장된다.  
불변, 필수 의존관계에 사용
```
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderServiceImpl() {
        ...
    }
}
```
생성자가 딱 1개만 있으면 @Autowired를 생략해도 자동 주입 된다

# 수정자 주입(setter 주입)
setter라 불리는 필드의 값을 변경하는 수정자 메서드를 통해서 의존관계를 주입   
선택, 변경 가능성이 있는 의존관계에 사용  

```
@Component
public class OrderServiceImpl implements OrderService {
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;
    
    @Autowired
    public void setMemberRepository() {
        ...
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        ...
    }
}
```

자바빈 프로퍼티 규약 예시  

```
class A {
    public void setA(int param) {
        ...
    }
    public int getA() {
        ...
    }
}
```

# 필드 주입 (비추천)
애플리케이션의 실제 코드와 관계 없는 테스트 코드  
스프링 설정을 목적으로 하는 @Configuration 같은 곳에서만 특별한 용도로 사용  

```
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DiscountPolicy discountPolicy;
}
```

# 일반 메서드 주입 (잘 사용하지 않음)
일반 메서드를 통해서 주입 받을 수 있다.    
한번에 여러 필드를 주입 받을 수 있다.  

```
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    public void init() {
        ...
    }
}
```