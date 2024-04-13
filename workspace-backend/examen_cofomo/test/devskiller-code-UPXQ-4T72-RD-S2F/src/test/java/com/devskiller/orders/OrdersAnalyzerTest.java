package com.devskiller.orders;

import com.devskiller.orders.model.Customer;
import com.devskiller.orders.model.Order;
import com.devskiller.orders.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class OrdersAnalyzerTest {

  private List<Order> orders;

  @Test
  public void shouldReturnMostValuableCustomer() {
    // given
    OrdersAnalyzer ordersAnalyzer = new OrdersAnalyzer();

    //when
    Optional<Customer> mostValuableCustomer = ordersAnalyzer.findMostValuableCustomer(orders.stream());

    // then
    assertThat(mostValuableCustomer.isPresent());
    assertThat(mostValuableCustomer.get().getFirstName()).isEqualTo("Max");
    assertThat(mostValuableCustomer.get().getLastName()).isEqualTo("King");
  }

  @Test
  public void shouldReturnMostPopularProducts() {
    // given
    OrdersAnalyzer ordersAnalyzer = new OrdersAnalyzer();

    //when
    List<Product> mostPopularProducts = ordersAnalyzer.findThreeMostPopularProducts(orders.stream());

    // then
    assertThat(mostPopularProducts).hasSize(3);
    assertThat(mostPopularProducts).extracting("name").containsExactly("Book 1", "Phone 1", "Book 2");
  }

  @Before
  public void setup() {
    orders = new ArrayList<>();
    Customer johnSmith = new Customer(randomId(), "John", "Smith");
    Customer alanDoe = new Customer(randomId(), "Alan", "Doe");
    Customer maxKing = new Customer(randomId(), "Max", "King");
    Customer aliceFoo = new Customer(randomId(), "Alice", "Foo");
    Product bike = new Product("Bike", new BigDecimal("350.00"));
    Product book1 = new Product("Book 1", new BigDecimal("23.00"));
    Product book2 = new Product("Book 2", new BigDecimal("44.00"));
    Product book3 = new Product("Book 3", new BigDecimal("99.00"));
    Product phone1 = new Product("Phone 1", new BigDecimal("156.33"));
    Product phone2 = new Product("Phone 2", new BigDecimal("231.99"));
    Product phone3 = new Product("Phone 3", new BigDecimal("199.99"));

    createOrder(johnSmith).addOrderLine(bike, 1);
    createOrder(johnSmith).addOrderLine(book1, 1)//1
					      .addOrderLine(book2, 2)//1
					      .addOrderLine(book3, 3);//1
    createOrder(johnSmith).addOrderLine(phone1, 1);
    createOrder(alanDoe).addOrderLine(book1, 1)//2
				        .addOrderLine(phone1, 1)//1
				        .addOrderLine(phone2, 1);//1
    createOrder(maxKing).addOrderLine(book1, 1)//3
				        .addOrderLine(phone1, 1)//2
				        .addOrderLine(phone2, 2);//2
    createOrder(maxKing).addOrderLine(phone3, 3);
    createOrder(aliceFoo).addOrderLine(book1, 1)//4
					     .addOrderLine(book2, 2)//2
					     .addOrderLine(book3, 3);//2
  }

  private Order createOrder(Customer customer) {
    Order order = new Order(randomId(), customer);
    orders.add(order);
    return order;
  }

  private static String randomId() {
    return UUID.randomUUID().toString();
  }

}
