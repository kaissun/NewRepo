package com.supermarket;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.supermarket.common.CommonTestCase;
import com.supermarket.util.Constants;

/**
 *
 * Test "Buy One Get One Free" with oranges:
 * <li>First test: with no item (0 orange -> 0)</li>
 * <li>Second test: with one item (1 orange -> 0.5)</li>
 * <li>Third test: with two items (2 oranges -> 1)</li>
 * <li>Fourth test: with three items (3 oranges -> 1.5)</li>
 * <br>
 * @author Kaissun
 *
 */
public class NoDiscountTest extends CommonTestCase {

	public static final String SELECTED_ITEM = Constants.ORANGE;

	@Test
	public void testNoDiscount() {
		float total;
		quantities = App.checkoutQantities(cart);
	    orders = App.generateOrders(quantities);
		total = App.totalOfOrders(orders);
		assertEquals(0, total, 0);
		// First add
		total = addOneItemAndGetTotal(SELECTED_ITEM);
		assertEquals(0.5, total, 0.00001);
		// Second add
		total = addOneItemAndGetTotal(SELECTED_ITEM);
		assertEquals(1, total, 0.00001);
		// Third add
		total = addOneItemAndGetTotal(SELECTED_ITEM);
		assertEquals(1.5, total, 0.00001);
		
		
	}

}