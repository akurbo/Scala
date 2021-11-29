

/** Напишите вашу реализацию в тестовые функции.
  * 
  * https://docs.scala-lang.org/overviews/collections/maps.html
  */
object Maps {

  case class User(name: String, age: Int)


  def main(args: Array[String]): Unit = {
    println()
    println(testGroupUsers(Seq(User("Billy", 45), User("Tom", 36), User("Adam", 18))))
    println()

    println(testNumberFrodos(Map("user1" -> User("Adam", 18), "user2" -> User("Tom", 36), "user3" -> User("Billy", 45))))
    println()

    println(testUnderaged(Map("user1" -> User("Adam", 18), "user2" -> User("Tom", 36), "user3" -> User("Billy", 45))))
    println()
  }

  /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`) и вычислите средний возраст: `name -> averageAge`
       *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
       */
  def testGroupUsers(users: Seq[User]): Map[String, Int] = {
    val averageAge = users.foldLeft(0)((sum, user) => sum + user.age ) / users.length
    users.groupBy(user => user.name).keys.map(key =>  key -> averageAge).toMap
  }

  /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей, содержащихся в Map, содержат подстроку "Adam"?
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testNumberFrodos(map: Map[String, User]): Int = map.count(_._2.name.contains("Adam"))

  /* c) Удалите всех пользователей возраст которых менее 35 лет.
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testUnderaged(map: Map[String, User]): Map[String, User] = map.filter(_._2.age >= 35)
}
