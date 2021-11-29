

/** Напишите ваши решения в тестовых функциях.
  * 
  * https://www.scala-lang.org/api/2.12.3/scala/collection/immutable/StringOps.html
  */
object Strings {

  def main(args: Array[String]): Unit = {
    println()
    println(testUppercase("hello"))
    println()

    println(testInterpolations("Artem", 20))
    println()

    println(testComputation(4, 7))
    println()

    println(testTakeTwo("hello"))
    println(testTakeTwo("hi"))
    println(testTakeTwo("a"))
    println()
  }

  /* a) Преобразуйте все символы типа Char в верхний регистр (не используйте заглавные буквы).
   *    
   */
  def testUppercase(str: String): String = str.map(_.toUpper)

  /* b) Вставьте следующие значения в строку:
   *       Hi my name is <name> and I am <age> years old.
   *    
   */
  def testInterpolations(name: String, age: Int): String = s"Hi my name is $name and I am $age years old."

  /* c) Добавьте два числа в следующую строку:
   *       Hi,
   *       now follows a quite hard calculation. We try to add:
   *         a := <value of a>
   *         b := <value of b>

   *         result is <a + b>
   * 
   *   
   */
  def testComputation(a: Int, b: Int): String = s"Hi,\nnow follows a quite hard calculation. We try to add:\na := $a\nb := $b\n\nresult = ${a + b}"

  /* d) Если длина строки равна 2, верните всю строку, иначе верните первые два символа строки.
   */
  def testTakeTwo(str: String): String = str.length match {
    case 2 => str
    case 1 | 0 => "Длина строки меньше 2"
    case _ => str.take(2)
  }
}
