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
