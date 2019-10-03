package com.supermarket;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.supermarket.common.CommonTestCase;
import com.supermarket.util.Constants;

/**
 * Test "Buy One Get One Free" with Apples
 * <li>First test: with no item (-> 0)</li>
 * <li>Second test: with one item (apple -> 0.2)</li>
 * <li>Third test: with two items (2 apples -> 0.2) </li>
 * <li>Fourth test: with three items (3 apples -> 0.4)</li>
 *
 * @author Kaissun
 *
 */
public class BOGOFTest extends CommonTestCase {

	public static final String SELECTED_ITEM = Constants.APPLE;

	
	@Test
	public void testBOGOFOffer() {
		float total;
		quantities = App.checkoutQantities(cart);
	    orders = App.generateOrders(quantities);
		total = App.totalOfOrders(orders);
		assertEquals(0, total, 0);
		// First add
		total = addOneItemAndGetTotal(SELECTED_ITEM);
		assertEquals(0.2, total, 0.00001);
		// Second add
		total = addOneItemAndGetTotal(SELECTED_ITEM);
		assertEquals(0.2, total, 0.00001);
		// Third add
		total = addOneItemAndGetTotal(SELECTED_ITEM);
		assertEquals(0.4, total, 0.00001);
	}
}