package gameOfLife

class Universe(position: Position) {
  
  def this() = this(null)
  
  def iter(): Universe = {
    new Universe
  }
  
  def cellAliveAtPosition(pos: Position) = {
    false
  }
}
