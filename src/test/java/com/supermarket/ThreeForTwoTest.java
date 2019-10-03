package com.supermarket;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.supermarket.common.CommonTestCase;
import com.supermarket.util.Constants;
/**
 * 
 * <li>Test "Three For Two" offer with watermelons</li> 
 * <li>First test: with no item (0 watermelon -> 0)</li>
 * <li>Second test: with one item (1 watermelon -> 0.8)</li>
 * <li>Third test: with two items (2 watermelons -> 1.6)</li>
 * <li>Fourth test: with three items (3 watermelons -> 1.6)</li>
 * <br>
 * @author Kaissun
 *
 */
public class ThreeForTwoTest extends CommonTestCase {

	public static final String SELECTED_ITEM = Constants.WATERMELON;


	@Test
	public void testThreeForTwoOffer() {
		float total;
		quantities = App.checkoutQantities(cart);
	    orders = App.generateOrders(quantities);
		total = App.totalOfOrders(orders);
		assertEquals(0, total, 0);
		// First add
		total = addOneItemAndGetTotal(SELECTED_ITEM);
		assertEquals(0.8, total, 0.00001);
		// Second add
		total = addOneItemAndGetTotal(SELECTED_ITEM);
		assertEquals(1.6, total, 0.00001);
		// Third add
		total = addOneItemAndGetTotal(SELECTED_ITEM);
		assertEquals(1.6, total, 0.00001);
	}

}