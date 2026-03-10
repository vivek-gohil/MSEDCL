package com.msedcl.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.domain.Order;
import com.msedcl.main.service.OrderService;
// Singleton(default) , Prototype , Request (MVC) , ServletContext (MVC) , ApplicationContext (MVC) , Session (MVC)
public class OrderMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.msedcl.main");

		OrderService orderService1 = applicationContext.getBean(OrderService.class);
		System.out.println(orderService1.hashCode());
		Order order = new Order(101, "Laptop", 90000);
		orderService1.processOrder(order);
		
		System.out.println("-".repeat(80));
		OrderService orderService2 = applicationContext.getBean(OrderService.class);
		System.out.println(orderService2.hashCode());
		
	}
}
