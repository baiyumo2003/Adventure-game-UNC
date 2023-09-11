package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {

  private final ArrayList<Item> list;

  public InventoryImpl() {
    this.list = new ArrayList<Item>();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public int getNumItems() {
    return list.size();
  }

  @Override
  public List<Item> getItems() {
    return (ArrayList<Item>) this.list.clone();
  }

  @Override
  public void addItem(Item item) {
    this.list.add(item);
  }

  @Override
  public void removeItem(Item item) {
    this.list.remove(item);
  }

  @Override
  public void clear() {
    this.list.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    ArrayList<Item> temp = new ArrayList<Item>();
    temp = (ArrayList<Item>) other.getItems();
    other.clear();
    this.list.addAll(temp);
  }
}
