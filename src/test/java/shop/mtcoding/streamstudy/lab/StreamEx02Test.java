package shop.mtcoding.streamstudy.lab;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class StreamEx02Test {

    @Test
    public void ex05() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream()
        .skip(1)
        // skip은 2부터 시작
        .peek(t -> {
            System.out.println("peek : " + t);
        })
        .limit(2)
        // .map(t -> t * 2 )
        
        // peek()이 2,3,4가 나오길 기대하는데 왜 limit이 peek보다 먼저 실행되는가?

        .collect(Collectors.toList());   
        newList.stream().forEach(t->System.out.println(t)); // 2,3        
    }   

    @Test
    public void ex04() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream().limit(2).collect(Collectors.toList());   

        newList.stream().forEach(t->System.out.println(t)); // 1, 2

    }   

    @Test
    public void ex03() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream()
                .filter(t -> t != 3)
                .map(t -> {
                    Integer r = t * 2;
                    return r;
                })
                // 다시 처음부터 index 0으로 돌아감
                // 각각의 값을 찾아가서 연산을 할 수 있음
                .collect(Collectors.toList());
        
        newList.stream().forEach(t->System.out.println(t)); // 2, 4, 8
    }

    @Test
    public void ex02() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream().filter(t-> t % 2 != 0).collect(Collectors.toList());
        
        newList.stream().forEach(t->System.out.println(t));
        // list.stream().filter(t-> true); 한줄로만 가능
    }

    @Test
    public void ex01() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream().filter(t-> t==3).collect(Collectors.toList());
        
        newList.stream().forEach(t->System.out.println(t));
        // list.stream().filter(t-> true); 한줄로만 가능
    }
}
