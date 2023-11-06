import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFlatMap {

    public static void main(String[] args) {
        List<List<Integer>> parentNumberList = new ArrayList<>();

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(12);
        numberList.add(71);
        numberList.add(26);
        numberList.add(366);
        numberList.add(63);
        numberList.add(88);
        numberList.add(99);

        List<Integer> numberList2 = new ArrayList<>();
        numberList2.add(21);
        numberList2.add(122);
        numberList2.add(721);
        numberList2.add(262);
        numberList2.add(3626);
        numberList2.add(263);
        numberList2.add(828);
        numberList2.add(992);

        parentNumberList.add(numberList);
        parentNumberList.add(numberList2);
        parentNumberList.add(Arrays.asList(4, 6, 9));

        System.out.println(parentNumberList);

        System.out.println("\u001B[31m//////////////////////////////////////////////////////");

        Stream<Integer> flattenedStream = parentNumberList.stream()
                .flatMap(List::stream);


        Stream<Integer> evenNumbersStream = flattenedStream.filter(number -> number % 2 == 0);


        List<Integer> evenNumbersList = evenNumbersStream.collect(Collectors.toList());

        System.out.println("Even numbers in the parentNumberList: " + evenNumbersList);


        System.out.println("\u001B[36m//////////////////////////////////////////////////////");

        long integerCount = parentNumberList.stream()
                .mapToLong(s -> s.size())
                .sum();

        long integerCount2 = parentNumberList.stream()
//                .flatMap(s -> s.stream())
                .count();

        long integerCount3 = parentNumberList.stream().mapToLong(Collection::size)
                .sum();

        long integerCount4 = parentNumberList.stream()
                .flatMap(s -> s.stream())
                .mapToInt(s -> s.intValue())
                .count();

        long integerCount5 = parentNumberList.stream()
                .flatMap(s -> s.stream())
                .mapToInt(s -> s.intValue())
                .sum();

        IntSummaryStatistics sumstatistic1 = parentNumberList.stream()
                        .flatMap(s -> s.stream())
                                .mapToInt(s -> s.intValue())
                                        .summaryStatistics();

        IntSummaryStatistics sumstatistic2 = parentNumberList.stream()
                .flatMap(s -> s.stream())
                .mapToInt(s -> s)
                .summaryStatistics();

        IntSummaryStatistics sumstatistic3 = parentNumberList.stream()
                .flatMap(Collection::stream)
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println(integerCount);
        System.out.println(integerCount2);
        System.out.println(integerCount3);
        System.out.println(integerCount4);
        System.out.println(integerCount5);
        System.out.println(sumstatistic1);
        System.out.println(sumstatistic2);
        System.out.println(sumstatistic3);


    }



}
