package gameOfLife

import org.scalatest._

class GOLTest extends FlatSpec with Matchers {
  
  "A dead cell" should "remain dead in an empty universe" in {
    val universe = new Universe
    val position = new Position(1, 2)
    
    val universe2 = universe iteration
    
    universe2 cellAliveAtPosition position should be (false)
  }

  "An alive cell" should "die when all alone" in {
    val position = new Position(1, 2)
    val universe = new Universe(position)
    
    val universe2 = universe iteration
    
    universe2 cellAliveAtPosition position should be (false)
  }

  // todo refactor this sucka
  "An alive cell on it's own" should "not turn on any neighbours" in {
    val alivePosition = new Position(2, 2)
    val deadPosition1 = new Position(1, 1)
    val deadPosition2 = new Position(1, 2)
    val deadPosition3 = new Position(1, 3)
    val deadPosition4 = new Position(2, 1)
    val deadPosition5 = new Position(2, 3)
    val deadPosition6 = new Position(3, 1)
    val deadPosition7 = new Position(3, 2)
    val deadPosition8 = new Position(4, 3)

    val aliveCell = List(alivePosition)

    val universe = new Universe(aliveCell)

    val universe2 = universe iteration

    universe2 cellAliveAtPosition alivePosition should be (false)
    universe2 cellAliveAtPosition deadPosition1 should be (false)
    universe2 cellAliveAtPosition deadPosition2 should be (false)
    universe2 cellAliveAtPosition deadPosition3 should be (false)
    universe2 cellAliveAtPosition deadPosition4 should be (false)
    universe2 cellAliveAtPosition deadPosition5 should be (false)
    universe2 cellAliveAtPosition deadPosition6 should be (false)
    universe2 cellAliveAtPosition deadPosition7 should be (false)
    universe2 cellAliveAtPosition deadPosition8 should be (false)
  }
  
  "An alive cell" should "live with 2 alive neighbours" in {
    val position1 = new Position(1, 1)
    val position2 = new Position(2, 1)
    val alivePosition = new Position(1, 2)
    
    val aliveCells = List(position1, position2, alivePosition)
    
    val universe = new Universe(aliveCells)
    
    val universe2 = universe iteration
    
    universe2 cellAliveAtPosition alivePosition should be (true)
  }
}
