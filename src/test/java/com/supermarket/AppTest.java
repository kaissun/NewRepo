package com.supermarket;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BOGOFTest.class, NoDiscountTest.class, ThreeForTwoTest.class, ExampleTest.class })
public class AppTest {

}
