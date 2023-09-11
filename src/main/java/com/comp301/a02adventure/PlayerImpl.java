package com.comp301.a02adventure;

public class PlayerImpl implements Player {

  private final String name;
  private final Inventory inventory;
  private Position postion;

  public PlayerImpl(String name, int startX, int startY) {
    // Constructor code goes here
    if (name == null) {
      throw new IllegalArgumentException("invalid input");
    }
    this.name = name;
    postion = new PositionImpl(startX, startY);
    inventory = new InventoryImpl();
  }

  @Override
  public Position getPosition() {
    return this.postion;
  }

  @Override
  public Inventory getInventory() {
    return this.inventory;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void move(Direction direction) {
    Position newPosition = postion.getNeighbor(direction);
    this.postion = newPosition;
  }
}
