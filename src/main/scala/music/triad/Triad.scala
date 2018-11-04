package music.triad

import music._
import music.Degree._
import music.note.Note

import com.typesafe.scalalogging.{LazyLogging => Logged}

object Triad {

    val I   = Major One
    val II  = Major Two
    val III = Major Three
    val IV  = Major Four
    val V   = Major Five
    val VI  = Major Six
    val VII = Major Seven

    val i   = Minor One
    val ii  = Minor Two
    val iii = Minor Three
    val iv  = Minor Four
    val v   = Minor Five
    val vi  = Minor Six
    val vii = Minor Seven

    import scala.collection.mutable.HashMap
    private def memoize[I, O](f: I => O): I => O = new HashMap[I, O]() {
        override def apply(key: I) = getOrElseUpdate(key, f(key))
    }

    // Do as much recursion as possible to populate the memo table
    def notes(triad: Triad): (Note, Note, Note) = memoize {
        val Triad(quality, rootDegree, inversion, key) = triad
        inversion match {
            case First => {
                val (root, third, fifth) = Triad(quality, rootDegree, Root, key).notes
                (third, fifth, root)
            }

            case Second => {
                val (root, third, fifth) = Triad(quality, rootDegree, Root, key).notes
                (fifth, root, third)
            }

            case Root => {
                if (key != One) {
                    Triad(quality, rootDegree + key, Root, One).notes
                } else {
                    val thirdDegree = rootDegree + 2
                    val fifthDegree = rootDegree + 4
                    
                }
            }
        }
    }
}

sealed trait Inversion

case object Root   extends Inversion
case object First  extends Inversion
case object Second extends Inversion

object Inversion {
    def allInversions(triad: Triad) = triad match {
        case Triad(quality, root, _, key) => Seq(
            Triad(quality, root, Root, key),
            Triad(quality, root, First, key),
            Triad(quality, root, Second, key)
        )
    }
}

final case class Triad(
  quality: Quality,
  root: Degree,
  inversion: Inversion = Root,
  key: Degree = One) extends Logged {

    def + =   Triad(Augmented,  root, inversion, key)
    def m =   Triad(Minor,      root, inversion, key)
    def M =   Triad(Major,      root, inversion, key)
    def dim = Triad(Diminished, root, inversion, key)

    def Root   = Triad(quality, root, music.triad.Root, key)
    def First  = Triad(quality, root, music.triad.First, key)
    def Second = Triad(quality, root, music.triad.Second, key)

    def of(degree: Degree) = Triad(quality, root, inversion, degree)

    def notes = Triad.notes(this)
}
