package jpa;

import jpa.domain.Address;

public class ValueMain {
    public static void main(String[] args) {

        /**
         * 기본값 타입
         *
         * 생명주기를 엔티티의 의존
         *
         */
        //  primitive type
        int a = 10;
        int b = a;

        a = 20;

        // a 만 20
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // 래퍼 클래스, 특수한 클래스
        Integer a1 = new Integer(10);
        Integer b1 = a1;

//        a1.setValue(20);

        // 둘다 20
        System.out.println("a1 = " + a1);
        System.out.println("b1 = " + b1);

        /**
         * 임베디드 타입 사용법
         * - @Embeddable : 값 타입을 정의하는 곳에 표시
         * - @Embedded : 값 타입을 사용하는 곳에 표시
         * - 기본 생성자 필수
         *
         * 장점
         * - 재사용
         * - 높은 응집도
         * - Period.isWork()처럼 해당 값 타입만 사용하는 의미 있는 메소드를 만들 수 있음
         * - 임베디드 타입을 포함한 모든 값 타입은, 값 타입을 소유한 엔티티에 생명주기를 의존함
         *
         * 단점
         * -
         */


        /**
         * 값타입의 비교
         *
         * - 동일성(identity) 비교 : 인스턴스의 참조 값을 비교, == 사용
         * - 동등성(equivalence) 비교 : 인스턴스의 값을 비교, equals() 사용
         * - 값 타입은 a.equals(b)를 사용해서 동등성 비교를 해야 함
         * - 값타입의 equals() 메소드를 적절하게 재정의(주로 모든 필드 사용)
         *
         * - 오버라이드 를 사용해서 equal 오버라이드 하여 비교해야한다.
         */
        Address address1 = new Address("newCity", "street", "10000");
        Address address2 = new Address("newCity", "street", "10000");
        System.out.println("address1 == address2 : " + (address1 == address2));
        // Address에 equals 오버라이딩 해야함.
        System.out.println("address1 equals address2 : " + (address1.equals(address2)));



    }
}
