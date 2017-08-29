package nvrs

import org.scalatest.{FunSpecLike, GivenWhenThen, Matchers}

import scala.collection.mutable

/**
  *
  */
class RandomGreeterSpec extends FunSpecLike with GivenWhenThen with Matchers {

  describe("A RandomGreeter") {
    it("should fail if less than two greeters are passed as constructor arguments") {

      an [IllegalArgumentException] should be thrownBy {
        new RandomGreeter(List.empty[Greeter])
      }

      an [IllegalArgumentException] should be thrownBy {
        new RandomGreeter(List(new Greeter("Hi")))
      }
    }

    it("should have some variance in the way it greets") {
      Given("a random greeter with two ways to greet")
      val rGreeter = new RandomGreeter(List(new Greeter("Hi"), new Greeter("Hello")))

      When("100 invocations of greet are performed for the same person")
      val person = "John"
      val greets = mutable.Set.empty[String]
        for (_ <- 1 to 100) yield {
          greets add rGreeter.greet(person)
        }

      Then("there should exactly two different greetings observed")
      greets.size shouldBe 2
    }
  }
}
