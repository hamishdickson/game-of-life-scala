package gameOfLife

class Universe(positions: List[Position]) {
  type Cell = (Int, Int)
  
  def this() = this(List())
  def this(position: Position) = this(List(position))
  
  def iteration(): Universe = new Universe
  
  def cellAliveAtPosition(pos: Position) = false
  
  private def neighbours(position: Position) = position match {
    case pos =>
      for {
        nx <- (pos.posX - 1) to (pos.posX + 1)
        ny <- (pos.posY - 1) to (pos.posY + 1)
        if !(nx == pos.posX && ny == pos.posY)
      } yield new Position(nx, ny)
  }
}
