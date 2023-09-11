package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private final int x;
  private final int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public Position getNeighbor(Direction direction) {
    PositionImpl result = null;
    switch (direction) {
      case EAST:
        result = new PositionImpl(this.x + 1, this.y);
        break;
      case WEST:
        result = new PositionImpl(this.x - 1, this.y);
        break;
      case NORTH:
        result = new PositionImpl(this.x, this.y + 1);
        break;
      case SOUTH:
        result = new PositionImpl(this.x, this.y - 1);
        break;
    }
    return result;
  }
}
