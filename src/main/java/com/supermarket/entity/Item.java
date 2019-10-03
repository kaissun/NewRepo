package com.supermarket.entity;

/**
 * 
 * An item entity, defined by its name, exact price and their assigned {@link Offer}.
 * 
 *  * @author KaisBS
 *
 */
public class Item
{
  public final String name;
  // Using float is better for currencies, double is not advised
  public final float price;
  public final Offer offer;

  public Item(String name, float price, Offer offer){
    this.name = name;
    this.price = price;
    this.offer = offer;
  }

  public String getName() {
    return name;
  }
}