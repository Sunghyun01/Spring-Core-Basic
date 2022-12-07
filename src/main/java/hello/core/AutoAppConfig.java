package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        // basePackageClasses =  AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    /*
    * ★수동 빈 등록
    *
    * 수동 빈 등록 코드
    *    @Bean(name = "memoryMemberRepository")
    *    public MemberRepository memberRepository() {
    *       return new MemoryMemberRepository();
    *    }
    *
    * 1. 수동 빈 등록시 남는 로그
    *    Overriding bean definition for bean 'memoryMemberRepository' with a different
    *    definition: replacing
    *
    * 2. 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본 값을 바꾸었다.
    *
    * 3. 수동 빈 등록, 자동 빈 등록 오류시 스프링 부트 에러
    *    Consider renaming one of the beans or enabling overriding by setting
    *    spring.main.allow-bean-definition-overriding=true
    *
    * */

}
