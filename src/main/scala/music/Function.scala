package music

import Triad._

sealed trait Function {
    val chords: Seq[Triad]
}

case object Tonic extends Function {
    val chords = Seq(I)
}

case object DominantPrep extends Function {
    val chords = Seq(ii, IV, vi)
}

case object Dominant extends Function {
    val chords = Seq(V, Diminished vii)
}
