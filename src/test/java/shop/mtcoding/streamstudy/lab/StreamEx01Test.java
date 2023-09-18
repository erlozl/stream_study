package shop.mtcoding.streamstudy.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamEx01Test {

    @Test
    public void ex05() {
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

        // 중복된 값을 제거하고 리스트로 변환
        List<Integer> newList = list.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        // 값 출력하기
        for (Integer i : newList) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void ex04() {
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        List<Integer> newList = new ArrayList<>();
        // 스트림 쓰지않고 중복된 값 제거하기
        
        // 1. list -> newList에 깊은 복사하기
        for(Integer t : list) {
            newList.add(t);
            // System.out.println(newList.size());
            // System.out.println("list_get" + t);
        }

        // 2. newList에서 동일한 값 제거하기


        for(int i=0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
            for(int j=i+1; j < newList.size(); j++) {
                if(newList.get(i)==newList.get(j)) {
                    newList.remove(j);
                }
            }
        }
        System.out.println(newList);


    }

    @Test
    public void ex03() {
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        List<Integer> lowList = new ArrayList<>();
        List<Integer> highList = new ArrayList<>();

        // 얕은 복사
        lowList = list;

        // 깊은 복사
        for(Integer i : list ) {
            highList.add(i);
        }
    }
    
    // 스트림의 중간연산
    @Test
    public void ex02() {
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

        Stream<Integer> stream = list.stream();
        stream.distinct().forEach(t->{
            // 이거 하나로 중복된 게 다 날라간거임
            System.out.println(t);
        }); 
    }

    // 스트림의 생성
    @Test
    public void ex01() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(1);
        
        Stream<Integer> stream = list.stream();
        stream.forEach(t -> {
            System.out.println(t);
        });
        System.out.println("===========");

        // 2번째 방법
        // stream.forEach(System.out::println);

        // 3번째 방법
        // stream.forEach(new Consumer<Integer>() {
        //     @Override
        //     public void accept(Integer t) {
        //         System.out.println(t);
        //     }
        // });

        // 타입은 Integer임 - 람다식에서는 타입이 생략가능
        // 매개변수가 하나면 괄호 필요없음, 두개는 필요있다
        // t에 stream이 순회하면서 하나씩 소비를 함
        // 소비되는 데이터가 t임
        
        // return 타입 void - for문처럼 순회하는 거


    }
}
