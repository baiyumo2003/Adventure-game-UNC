package com.comp301.a02adventure;

public class CellImpl implements Cell {
  private final PositionImpl position;
  private String name;
  private String description;
  private Inventory chest = null;
  private boolean visit = false;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null || description == null) {
      throw new IllegalArgumentException("unvalid input");
    }
    position = new PositionImpl(x, y);
    this.name = name;
    this.description = description;
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("invalid");
    }
    this.name = name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("invalid");
    }
    this.description = description;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  @Override
  public Inventory getChest() {
    return this.chest;
  }

  @Override
  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException("invalid");
    }
    this.chest = chest;
  }

  @Override
  public boolean getIsVisited() {
    return this.visit;
  }

  @Override
  public boolean hasChest() {
    return this.chest != null;
  }

  @Override
  public void visit() {
    this.visit = true;
  }
}
