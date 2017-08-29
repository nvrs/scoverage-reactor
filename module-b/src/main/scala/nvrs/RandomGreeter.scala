package nvrs

/**
  *
  */
class RandomGreeter(greeters: Seq[Greeter]) {
  require(greeters.size >= 2)

  val r = new scala.util.Random()

  def greet(person: String): String = {
    greeters(r.nextInt(greeters.size)).greet(person)
  }
}
