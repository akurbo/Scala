package exercise1

/** Напишите отдельные функции, решающие поставленную задачу. 
  * 
  * Синтаксис:
  *   // метод
  *   def myFunction(param0: Int, param1: String): Double = // тело
  * 
  *   // значение
  *   val myFunction: (Int, String) => Double (param0, param1) => // тело
  */
object Functions {

  def main(args: Array[String]): Unit = {
    println(testCircle(2))
    println(testRectangleCurried(4, 5))
    println(testRectangleUc(6, 7))
    }

  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */

  def circle(r: Double): Double = r * r * Math.PI

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = circle(r)

  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */

  def curried(a: Double)(b: Double): Double = a * b

  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = {
    val muli = curried(a)_
    muli(b)
  }

  // c) Напишите не карированную функцию для расчета площади прямоугольника.

  def unCurried(a: Double, b: Double): Double = a * b

  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = unCurried(a, b)
}
