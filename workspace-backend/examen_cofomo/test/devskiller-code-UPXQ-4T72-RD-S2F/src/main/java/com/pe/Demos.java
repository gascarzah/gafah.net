package com.pe;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.devskiller.orders.model.Product;

public class Demos {

	public static void main(String[] args)
    {
//        Stream<Integer> evenNumInfiniteStream = Stream.iterate(0, n -> n + 2);
//         
//        List<Integer> newList = evenNumInfiniteStream
//                .skip(5)
//                .limit(10)
//                .collect(Collectors.toList());
//        System.out.println(newList);
		
		Stream.of("d2", "a2", "b1", "b3", "c")
//		.collect(Collectors.toMap(
//		        p -> p.age,
//		        p -> p.name,
//		        (name1, name2) -> name1 + ";" + name2));

		
		.map(s-> {
			System.out.println("map: "+s);
			return s.toUpperCase();
		})
		.anyMatch(s -> {
			System.out.println("anymatch: " + s);
			return s.startsWith("A");
		})
		;
		
		
    }
//	Product p = new Product("", BigDecimal.valueOf(2.3));
//	produ
}
