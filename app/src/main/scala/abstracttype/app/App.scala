/*
 * This Scala source file was generated by the Gradle 'init' task.
 */
package abstracttype.app

import abstracttype.utilities.StringUtils
import org.apache.commons.text.WordUtils

import scala.reflect.ClassTag

trait ArrayTraits[T] {
  type AryType

  def makeContainer(sz: Int): AryType
}

implicit object IntArrayTraits extends ArrayTraits[Int] {
  override type AryType = Array[Int]

  override def makeContainer(sz: Int) = new Array[Int](sz)
}

implicit object BooleanArrayTraits extends ArrayTraits[Boolean] {
  override type AryType = Array[Int]

  override def makeContainer(sz: Int) = new Array[Int](sz)
}


class SquareArray[T](val sz: Int)(implicit val aryTraits: ArrayTraits[T]) {

  import aryTraits._

  val ary: AryType = makeContainer(sz)
}

class SquareArray2[T](val sz: Int)(implicit ct: ClassTag[T]) {
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

    val ary2 = SquareArray2[Int](2)

    println(ary2.ary.toList)

    val ary3 = SquareArray2[Boolean](3)
    println(ary3.ary.toList)
  }
}
