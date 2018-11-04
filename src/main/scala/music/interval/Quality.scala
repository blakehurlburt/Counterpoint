package music.interval

import music._

sealed trait Quality {
    def Second  = Interval(this, Two)
    def Third   = Interval(this, Three)
    def Fourth  = Interval(this, Four)
    def Fifth   = Interval(this, Five)
    def Sixth   = Interval(this, Six)
    def Seventh = Interval(this, Seven)
    def Octave  = Interval(this, One)
}

case object Diminished extends Quality
case object Minor      extends Quality
case object Perfect    extends Quality
case object Major      extends Quality
case object Augmented  extends Quality
