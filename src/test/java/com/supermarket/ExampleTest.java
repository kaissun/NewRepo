package com.supermarket;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.supermarket.common.CommonTestCase;
import com.supermarket.util.Constants;

/**
 * Test a cart that contains as demanded : 
 * <li>4 apples</li>
 * <li>3 oranges</li>
 * <li>5 watermelons</li>
 * <br>
 * 
 * @author Kaissun
 *
 */
public class ExampleTest extends CommonTestCase {

	@Test
	public void testExample() {
		float total;
		addOneItemAndGetTotal(Constants.APPLE);
		addOneItemAndGetTotal(Constants.APPLE);
		addOneItemAndGetTotal(Constants.APPLE);
		addOneItemAndGetTotal(Constants.APPLE);
		addOneItemAndGetTotal(Constants.ORANGE);
		addOneItemAndGetTotal(Constants.ORANGE);
		addOneItemAndGetTotal(Constants.ORANGE);
		addOneItemAndGetTotal(Constants.WATERMELON);
		addOneItemAndGetTotal(Constants.WATERMELON);
		addOneItemAndGetTotal(Constants.WATERMELON);
		addOneItemAndGetTotal(Constants.WATERMELON);
		total = addOneItemAndGetTotal(Constants.WATERMELON);
		assertEquals(5.1, total, 0.00001);
	}

}