package gameOfLife

import org.scalatest._

class GOLTest extends FlatSpec with Matchers {
  
  "A dead cell" should "remain dead in an empty universe" in {
    val universe = new Universe
    val position = new Position(1, 2)
    
    val universe2 = universe iter()
    
    universe2 cellAliveAtPosition position should be (false)
  }

  "An alive cell" should "die when all alone" in {
    val position = new Position(1, 2)
    val universe = new Universe(position)
    
    val universe2 = universe iter()
    
    universe2 cellAliveAtPosition position should be (false)
  }
}
