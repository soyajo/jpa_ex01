package jpa;

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

    }
}
