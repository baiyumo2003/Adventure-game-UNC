package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {
  private final Map map;
  private final Player player;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException("invalid input");
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return this.player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return this.player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return this.player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    return this.player.getInventory().getNumItems() == this.map.getNumItems();
  }

  @Override
  public void printCellInfo() {
    System.out.println("Location: " + map.getCell(player.getPosition()).getName());
    System.out.println(map.getCell(player.getPosition()).getDescription());
    if (map.getCell(player.getPosition()).getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (map.getCell(player.getPosition()).hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    map.getCell(player.getPosition()).visit();
  }
  /**
   * This method handles a user's interaction when they try to open a treasure chest at the current
   * location. If a chest exists in the current Cell, it should be opened and its contents
   * transferred to the Player's Inventory. Hint: Use the transferFrom() method.
   *
   * <p>If there is no chest at the current Cell, print: "No chest to open, sorry!"
   *
   * <p>If there is a chest at the current Cell, but it is empty, print: "The chest is empty."
   *
   * <p>If the chest is not empty, transfer the chest contents to the Player's Inventory and print:
   * "You collected these items: [list of chest items]"
   *
   * <p>Hint: If you correctly set up the toString() method in the ItemImpl class, you should be
   * able to print the whole inventory by simply printing the chest items list. For example
   * something like: System.out.println("You collected these items: " + chest.getItems());
   */
  @Override
  public void openChest() {
    if (map.getCell(player.getPosition()).hasChest()) {
      if (map.getCell(player.getPosition()).getChest().isEmpty()) {
        System.out.println("The chest is empty.");
      } else {
        System.out.println(
            "You collected these items: "
                + map.getCell(player.getPosition()).getChest().getItems().toString());
        this.player.getInventory().transferFrom(map.getCell(player.getPosition()).getChest());
      }

    } else {
      System.out.println("No chest to open, sorry!");
    }
  }

  @Override
  public boolean canMove(Direction direction) {

    try {
      if (player.getPosition().getNeighbor(direction).getX() < map.getWidth()
          && player.getPosition().getNeighbor(direction).getY() < map.getHeight()
          && player.getPosition().getNeighbor(direction) != null
          && map.getCell(player.getPosition().getNeighbor(direction)) != null) {
        return true;
      }

    } catch (Exception E) {
      return false;
    }
    return false;
  }

  @Override
  public void move(Direction direction) {
    if (canMove(direction)) {
      player.move(direction);
      printCellInfo();
    } else {
      System.out.println("You can't go that way! Try another direction.");
    }
  }
}
