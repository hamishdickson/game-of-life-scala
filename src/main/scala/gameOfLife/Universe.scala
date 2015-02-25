package gameOfLife

class Universe(positions: List[Position]) {
  
  def this() = this(List())
  def this(position: Position) = this(List(position))
  
  def iteration(): Universe = new Universe
  
  def cellAliveAtPosition(pos: Position) = false
}
