package com.supermarket;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.supermarket.entity.Item;
import com.supermarket.entity.Offer;
import com.supermarket.entity.Order;
import com.supermarket.util.Constants;
/**
 * BNP Paribas Developer Recruitment Code Submission - SuperMarket
 * 
 * @author Kaissun - kais.benslama@gmail.com
 * 
 * @version 1.0
 *
 */
public class App {

	// Available items in the stock
	public static Map<String, Item> stock = new HashMap<>();
	// it will contain the list of added items by costumer
	static List<Item> cart = new ArrayList<>();

	static {
		// list of items available in the supermarket stock
		stock.put(Constants.APPLE, new Item(Constants.APPLE, 0.2f, Offer.BOGOF));
		stock.put(Constants.ORANGE, new Item(Constants.ORANGE, 0.5f, Offer.NONE));
		stock.put(Constants.WATERMELON, new Item(Constants.WATERMELON, 0.8f, Offer.THREEFORTWO));
	}

	/**
	 * Return the quantities of each item exists in the cart
	 * @param items
	 * @return Map
	 */
	public static Map<String, Long> checkoutQantities(List<Item> items) {
		// As we checkout, group items, counting them, so we can apply any offers
		return items.stream()
				.collect(Collectors.groupingBy(Item::getName, LinkedHashMap<String, Long>::new, Collectors.counting()));

	}

	/**
	 * Return a list of orders. Each order will have the price, the quantity and the offer applied 
	 * @param quantities
	 * @return List
	 */
	public static List<Order> generateOrders(Map<String, Long> quantities) {
		// With the grouped "barcodes" and associated quantities, work out any
		// offer discounts and create the receipt.
		return quantities.entrySet().stream().map(entry -> {
			Item item = stock.get(entry.getKey());
			return new Order(item, entry.getValue(), item.offer.offerFuntional.applyOffer(entry.getValue(), item.price));
		}).collect(Collectors.toList());
	}

	public static float totalOfOrders(List<Order> items) {
		return (float) items.stream().mapToDouble(entry -> {
			return entry.price + entry.offer;
		}).sum();
	}

	/**
	 * Print desired output with related number of orders, their discounts if exist
	 * and total value
	 * 
	 * @param orders
	 */
	public static void printOutput(List<Order> orders) {
		System.out.printf("Item      Quantity          Total    Discount\n");
		System.out.printf("===============================================\n");
		double total = orders.stream().mapToDouble(entry -> {
			System.out.printf("%-12s x%d    	    %.2f\n", entry.item.name, entry.quantity, entry.price);
			if (entry.offer != 0)
				System.out.printf("           %-25s %.2f\n", entry.item.offer.offerName, entry.offer);
			return entry.price + entry.offer;
		}).sum();
		System.out.printf("===============================================\n");
		System.out.printf("\nTOTAL OF ORDERS 	    %.2f\n", total);
	}
  
	public static void main(String[] args) {
		switch (args.length) {
		case 0:
			/*
			 * As per the demand, the cart will contain: 
			 * - 4 apples 
			 * - 3 oranges 
			 * - 5 watermelons
			 */
			cart.add(stock.get(Constants.APPLE));
			cart.add(stock.get(Constants.APPLE));
			cart.add(stock.get(Constants.APPLE));
			cart.add(stock.get(Constants.APPLE));
			cart.add(stock.get(Constants.ORANGE));
			cart.add(stock.get(Constants.ORANGE));
			cart.add(stock.get(Constants.ORANGE));
			cart.add(stock.get(Constants.WATERMELON));
			cart.add(stock.get(Constants.WATERMELON));
			cart.add(stock.get(Constants.WATERMELON));
			cart.add(stock.get(Constants.WATERMELON));
			cart.add(stock.get(Constants.WATERMELON));
			break;
		case 3:
			try {
				Stream.iterate(0, n -> n + 1).limit(Integer.parseInt(args[0]))
				.forEach(x -> cart.add(stock.get(Constants.APPLE)));
				Stream.iterate(0, n -> n + 1).limit(Integer.parseInt(args[1]))
				.forEach(x -> cart.add(stock.get(Constants.ORANGE)));
				Stream.iterate(0, n -> n + 1).limit(Integer.parseInt(args[2]))
				.forEach(x -> cart.add(stock.get(Constants.WATERMELON)));
			} catch (NumberFormatException e) {
				System.err.println("INORRECT! The three parameters should be numbers");
				System.exit(0);
			}
			break;

		default:
			System.err.println("INVALID! you must introduce exactly the 3 following parameters: <apple quantity> <orange quantity> <watermelon quantity>");
			System.exit(0);
			break;
		}
		
		Map<String, Long> quantities = checkoutQantities(cart);

		List<Order> orders = generateOrders(quantities);

		printOutput(orders);

	}
}