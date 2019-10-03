package com.supermarket.entity;
/**
 * Order entity assigned a specific {@link Item} and define exact quantity, 
 * equivalent price and offer discount according to the quantity.  
 * 
 * @author KaisBS
 *
 */
public class Order
{
  public final Item item;
  public final long quantity;

  // The non-discounted price
  public final float price;

  // Any offer discount. positive or zero when no offer is in effect
  public final float offer;

  public Order(Item item, long quantity, float offer) {
    this.item = item;
    this.quantity = quantity;
    this.price = quantity * item.price;
    this.offer = offer;
  }
}