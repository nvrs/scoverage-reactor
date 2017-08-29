package nvrs

/**
  *
  */
class Greeter(greeting: String) {

  def greet(person: String): String = {
    s"$greeting $person"
  }
}
