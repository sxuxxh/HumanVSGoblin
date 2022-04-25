/*
  FSE Cohort - Project6
  Human VS Goblin
  Interface for game moves
 */
package game.gameboard;

public interface IGameMove {
    void moveLeft();
    void moveRight();
    void moveUp();
    void moveDown();
    void exit();
}
