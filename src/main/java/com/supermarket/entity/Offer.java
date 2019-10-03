package com.supermarket.entity;

/**
 * Enumeration that contains the list of offers available in the supermarket.
 * Each offer has a function (lambda) and name that will be applied via a functional interface
 * (Such a strategy pattern) 
 * @author kaissun
 *
 */
public enum Offer
{
	NONE ("", (long quantity, float price) -> 0), // No offer
	BOGOF ("Buy One Get One Free", (long quantity, float price) -> (quantity / 2 + quantity % 2 - quantity) * price), // Buy one get one free
	THREEFORTWO ("Three for Two", (long quantity, float price) -> (quantity / 3 * 2 + quantity % 3 - quantity) * price); // Three for two

	public final String offerName;
	public final OfferFunctional offerFuntional;

	Offer(String name, OfferFunctional offerFuntional) {
		this.offerName = name;
		this.offerFuntional = offerFuntional;
	}

	@FunctionalInterface
	public interface OfferFunctional {
		public float applyOffer(long quantity, float price);
	}
  
}
