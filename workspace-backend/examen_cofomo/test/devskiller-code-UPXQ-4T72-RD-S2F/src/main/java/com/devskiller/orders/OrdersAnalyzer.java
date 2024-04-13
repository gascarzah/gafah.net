package com.devskiller.orders;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.devskiller.orders.model.Customer;
import com.devskiller.orders.model.Order;
import com.devskiller.orders.model.Product;

public class OrdersAnalyzer {

  /**
   * Should return at most three most popular products. Most popular product is the product that have the most occurrences
   * in given orders (ignoring product quantity).
   * If two products have the same popularity, then products should be ordered by name
   *
   * @param orders orders stream
   * @return list with up to three most popular products
   */
  public List<Product> findThreeMostPopularProducts(Stream<Order> orders) {
    

	  
return	   orders.flatMap(ol -> ol.getOrderLines().stream())   //stream<Object>
	    		.collect(Collectors.groupingBy(p -> p.getProduct(),Collectors.counting())) //Map<Object,Long>
	    		.entrySet() //Set<Map.Entry<Product,Long>>
	    		.stream() //Stream<Map.Entry<Product,Long>>
	    		.sorted((a,b) -> a.getKey().getName().compareTo(b.getKey().getName()))//Stream<Map.Entry<Product,Long>>
	    		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))//Stream<Map.Entry<Product,Long>>
	    		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue)-> oldValue,LinkedHashMap::new)) //Map<Objct,Object>
	    		.entrySet() //Set<Map.Entry<Product,Long>>
	    		.stream() //Stream<Map.Entry<Product,Long>>
	    		.map(e -> e.getKey()) //Stream<Object>
	    		.limit(3) //Stream<Product>
	    		.collect(Collectors.toList()) //List<Product>
	   ;

//    return orders.flatMap(ol -> ol.getOrderLines().stream())
//    		.collect(Collectors.groupingBy(p -> p.getProduct(),Collectors.counting()))
//    		.entrySet()
//    		.stream()
//    		.sorted((a,b) -> a.getKey().getName().compareTo(b.getKey().getName()))
//    		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//    		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue)-> oldValue,LinkedHashMap::new))
//    		.entrySet()
//    		.stream()
//    		.map(e -> e.getKey())
//    		.limit(3)
//    		.collect(Collectors.toList());
  }

  /**
   * Should return the most valuable customer, that is the customer that has the highest value of all placed orders.
   * If two customers have the same orders value, then any of them should be returned.
   *
   * @param orders orders stream
   * @return Optional of most valuable customer
   */
  public Optional<Customer> findMostValuableCustomer(Stream<Order> orders) {
//	  System.out.println(
//	  orders.collect( Collectors.groupingBy(c -> c.getCustomer(), 
//			  Collectors.summarizingInt(
//					  ol -> (ol.getOrderLines().stream()).mapToInt(p -> p.getQuantity()).sum()
//					  )
//			  ))
		
//			  orders.collect( Collectors.groupingBy(c -> c.getCustomer(), 
//					  Collectors.counting()
//					  ))
	  
//	  orders.collect( Collectors.groupingBy(c -> c.getCustomer(), 
//			  Collectors.mapping(p -> p.getQuantity())
//					  
//			  ))

//			  orders.collect(Collectors.groupingBy(c -> c.getCustomer(), 
//					  Collectors.summarizingInt(c -> c.getOrderLines().stream().map(q -> q.getQuantity()))))
			  
return	orders.collect( Collectors.groupingBy(c -> c.getCustomer(),
			  Collectors.summingLong( ol -> (ol.getOrderLines().stream())
					  .mapToLong(p -> (p.getProduct().getPrice().longValue()*p.getQuantity())).sum())))
			  .entrySet().stream().map(e -> e.getKey()).findFirst()
//);
	  
	  ;
//    return Optional.empty();

  }

}
