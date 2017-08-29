package nvrs

import org.scalatest.{FunSpecLike, GivenWhenThen, Matchers}

/**
  *
  */
class GreeterSpec extends FunSpecLike with GivenWhenThen with Matchers {

  describe("A Greeter") {
    it("should greet persons using their name"){
      val name = "John"
      val greeter = new Greeter("Hello")
      Given(s"a person named $name")
      When("the Greeter's greet method is invoked")
      val greeting = greeter.greet(name)
      Then("the resulting greeting must contain the person's name")
      greeting should include(name)
    }
  }
}
