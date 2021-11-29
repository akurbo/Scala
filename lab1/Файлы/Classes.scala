package exercise1

/*
 * 
 a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String
 * 
 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }
 *
 *
 * b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *      - cat, mammal, meat
 *      - parrot, bird, vegetables
 *      - goldfish, fish, plants
 * 
 *    Синтаксис: object MyClass {
 *              // статические поля и методы
 *            }
 *
 * c) Добавьте следующие метод в Animals:
 *      def eats(food: String): Boolean
 *
 *     который проверяет ест ли животное определенную пищу
 *
 * d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
 *    Вам все еще нужно поле `species`?
 *
 * e) Добавьте следующие функции в объект-компаньон Animal:
 *      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
 *      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
 *
 * f) Создайте трейт Food со следующими классами-образцами:
 *      - Meat
 *      - Vegetables
 *      - Plants
 *   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
 *      def apply(food: String): Option[Food]
 */


class Animal(n: String, s: String, f: String) {
  var name: String = n
  var species: String = s
  var food: String = f

  def eats(food: String): Boolean = this.food == food
}

object Animal {
  val cat:Animal = new Animal("cat", "mammal", "meat")
  val parrot: Animal = new Animal("parrot", "bird", "vagetables")
  val goldfish: Animal = new Animal("goldfish", "fish", "plants")

  var mammal: Mammal = Mammal("cat", Meat, 6)
  var fish: Fish = Fish("goldfish", Plants)
  var bird: Bird = Bird("parror", Vegetables)


  def knownAnimal(name: String): Boolean = {
    if (name == cat.name || name == parrot.name || name == goldfish.name) true
    else false
  }

  def apply(name: String): Option[Animal] = {
    if (name == cat.name) Some(cat)
    else if (name == goldfish.name) Some(goldfish)
    else if (name == parrot.name) Some(parrot)
    else null
  }

  def main(args: Array[String]): Unit = {
    println(cat.name + " " + cat.species + " " + cat.food)
    println(parrot.name + " " + parrot.species + " " + parrot.food)
    println(goldfish.name + " " + goldfish.species + " " + goldfish.food)

    println(cat.eats("fish"))

    println(knownAnimal("parrot"))

    println(apply("cat"))

    println(Food.apply("Meat"))
  }
}

object Food {
  def apply(food: String): Option[Food] = food match {
    case "Meat" => Some(Meat)
    case "Vegetables" => Some(Vegetables)
    case "Plants" => Some(Plants)
    case _ => null
  }
}

sealed trait Animals {

  val name: String
  val food: Food
}

case class Mammal(name: String, food: Food, weight: Int) extends Animals
case class Fish(name: String, food: Food)                extends Animals
case class Bird(name: String, food: Food)                extends Animals

sealed trait Food
case object Meat       extends Food
case object Vegetables extends Food
case object Plants     extends Food

