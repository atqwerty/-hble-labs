package part1

// Theoretical questions: why do we need abstraction
// Answer: We need abstraction in order to describe the fundamental properties of objects (or group of objects)
// How `traits` in Scala are used?
// Traits in Scala are used to describe and classify the behavior of object

trait Animal {
  // Is this abstract or concrete (implemented) member?
  // Answer: abstract
  def name: String

  // Is this abstract or concrete (implemented) member?
  // Answer: abstract
  def makeSound(): String
}

trait Walks {

  // What does this line mean?
  this: Animal =>
  // Answer: it allows us to 'mix' the traits, the Walks trait has all the variables of Animal scope

  // Is this abstract or concrete (implemented) member?
  // Why `name` parameter is available here?
  // Answer: it's concrete member
  // Answer: because of the 21st line 'this: Animal =>', with tish tne name def is in this scope
  def walk: String = s"$name is walking"

}


// Can Dog only extend from `Walks`?
// Answer: it extends from Walks, but due to the fact that Walks refers to Animal, we also must add it
// Try to fix Dog, so it extends proper traits
// Implement Dog class so it passes tests
case class Dog(val name: String) extends Walks with Animal{
  override def walk: String = s"$name is walking"
  def makeSound(): String  = { "Whooof" }
}

// Implement Cat class so it passes tests
case class Cat(val name: String) extends Animal with Walks{
  override def walk: String = s"$name is walking"
  def makeSound(): String = { "Miiyaaau" }
}

object Lab2 extends App {

  // Here we will test Dog and Cat classes

  val dog1 = Dog("Ceasar")
  val dog2 = Dog("Laika")

  assert(dog1.name == "Ceasar")
  assert(dog2.name == "Laika")

  assert(dog1.makeSound() == "Whooof")
  assert(dog2.makeSound() == "Whooof")

  assert(dog1.walk == "Ceasar is walking")
  assert(dog2.walk == "Laika is walking")

  val cat1 = Cat("Tosha")
  val cat2 = Cat("Chocolate")

  assert(cat1.name == "Tosha")
  assert(cat2.name == "Chocolate")

  assert(cat1.makeSound() == "Miiyaaau")
  assert(cat2.makeSound() == "Miiyaaau")

  assert(cat1.walk == "Tosha is walking")
  assert(cat2.walk == "Chocolate is walking")
  printf("Made by Markitanov Denis for KBTU FIT BHLE")
}