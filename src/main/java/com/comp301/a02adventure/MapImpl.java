package com.comp301.a02adventure;

public class MapImpl implements Map {
  private final int width;
  private final int height;
  private final int numItems;
  private final Cell[][] individual;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("invalid input");
    }
    this.width = width;
    this.height = height;
    this.numItems = numItems;
    individual = new Cell[width][height];
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x >= this.width || y >= this.height) {
      throw new IndexOutOfBoundsException("out bound");
    }
    return this.individual[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    return this.getCell(position.getX(), position.getY());
  }

  @Override
  public void initCell(int x, int y) {
    if (x > this.width - 1 || y > this.height - 1) {
      throw new IndexOutOfBoundsException("out bound");
    }
    this.individual[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return this.numItems;
  }
}
