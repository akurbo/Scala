
import scala.annotation.tailrec

/** Напишите свои решения в тестовых функциях.
  * 
  * Seq(1, 2) match {
  *   case head +: tail => ???
  *   case Nil          => ???
  *   case s            => ???
  * }
  * 
  * https://www.scala-lang.org/api/2.12.0/scala/collection/Seq.html
  */
// Примечание: напишите функции с хвостовой рекурсией

object Sequence {

  def main(args: Array[String]): Unit = {
    println()
    println(testLastElement(Seq(1, 2, 3)))
    println(testLastElement(Seq()))
    println()

    println(testZip(Seq(1, 2), Seq(3, 4)))
    println()

    println(testForAll(Seq(1, 2, 3))(_ > 2))
    println(testForAll(Seq(1, 2, 3))(_ < 4))
    println()

    println(testPalindrom(Seq(1, 2, 3)))
    println(testPalindrom(Seq(1, 2, 3, 2, 1)))
    println()

    println(testFlatMap(Seq(1, 2, 3)) (value => Seq(value * 2)))

  }

  /* a) Найдите последний элемент Seq.
   *    
   */

  def lastElement[A](seq: Seq[A]): Option[A] = {
    @tailrec
    def loop(rem: Seq[A]): Option[A] = rem match {
      case last +: Seq() => Some(last)
      case _ +: tail => loop(tail)
      case Seq() => None
    }
    loop(seq)
  }

  def testLastElement[A](seq: Seq[A]): Option[A] = lastElement(seq)

  /* b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))) - если Seq длиннее игнорируйте оставшиеся элементы.
   *    
   */

  def zip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = Seq((a(0), b(0)),(a(1), b(1)))

  def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = zip(a, b)

  /* c) Проверьте, выполняется ли условие для всех элементов в Seq.
   *    
   */

  def forAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = seq.forall(cond)

  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = forAll(seq)(cond)

  /* d) Проверьте, является ли Seq палиндромом
   *    
   */

  def palindrom[A](seq: Seq[A]): Boolean = seq == seq.reverse

  def testPalindrom[A](seq: Seq[A]): Boolean = palindrom(seq)

  /* e) Реализуйте flatMap используя foldLeft.
   *    
   */

  def flatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = seq.foldLeft(Seq[B]())((x, y) => x ++ f(y))

  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = flatMap(seq)(f)
}
