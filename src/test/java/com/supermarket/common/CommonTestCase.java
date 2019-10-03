package com.supermarket.common;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;

import com.supermarket.App;
import com.supermarket.entity.Item;
import com.supermarket.entity.Order;
/**
 * Common test case for the project
 * <br>
 * @author Kaissun
 *
 */
public class CommonTestCase {

	protected static List<Item> cart = null;
	protected Map<String, Long> quantities = null;
	protected List<Order> orders = null;

	@Before
	public void executedBeforeEach() {
		cart = new ArrayList<>();
	}
	
	public float addOneItemAndGetTotal(String selectedItem) {
		cart.add(App.stock.get(selectedItem));
		quantities = App.checkoutQantities(cart);
		orders = App.generateOrders(quantities);
		return App.totalOfOrders(orders);
	}

}
