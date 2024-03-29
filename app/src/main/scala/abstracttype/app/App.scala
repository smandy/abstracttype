/*
 * This Scala source file was generated by the Gradle 'init' task.
 */
package abstracttype.app

import abstracttype.utilities.StringUtils
import org.apache.commons.text.WordUtils

import scala.reflect.ClassTag

trait ArrayTraits[T] {
  // Abstract type AryType which is iterable
  type AryType <: Array[T]

  def makeContainer(sz: Int): AryType
}

object ArrayTraits {
  implicit object IntArrayTraits extends ArrayTraits[Int] {
    override type AryType = Array[Int]

    override def makeContainer(sz: Int) = new Array[Int](sz)
  }

  implicit object BooleanArrayTraits extends ArrayTraits[Boolean] {
    override type AryType = Array[Boolean]

    override def makeContainer(sz: Int) = new Array[Boolean](sz)
  }
}


class SquareArray[T](val sz: Int)(implicit val aryTraits: ArrayTraits[T]) {
  import aryTraits._

  val ary: AryType = makeContainer(sz)

  override def toString = s"SquareArray($sz, ${ary.mkString("[", ",", "]")})"
}

class SquareArray2[T : ClassTag](val sz: Int) {
  val ary : Array[T] = Array.ofDim[T](sz)
}

object App {
  def main(args: Array[String]): Unit = {

    println("Flubbadub!!!")

    val x = implicitly(Numeric[Int])
    println(x)

    print(scala.util.Properties.versionNumberString)

    //val tmp = SquareArray[Int]()

    val x2 = Numeric[Int]

    println(x2.zero)

    val ary1 = SquareArray[Int](2)
    println(ary1)

    val ary2 = SquareArray[Boolean](2)
    println(ary2)

    val sary2 = SquareArray2[Int](2)
    println(sary2.ary.toList)

    val sary3 = SquareArray2[Boolean](3)
    println(sary3.ary.toList)
  }
}
