package counterpoint

import music._
import music.Triad._
import music.Inversion.allInversions

sealed trait Function {
    val chords: Seq[Triad]
}

case object Tonic extends Function {
    val chords = Seq(I Root, I First)
}

case object DominantPrep extends Function {
    val chords = Seq(ii, IV, vi)
                    .map(allInversions _)
                    .flatten
}

case object Dominant extends Function {
    val chords = Seq(I Second) ++ allInversions(V) ++ allInversions(vii dim)

    // for "Dominant Prep" instead of "DominantPrep"
    def Prep = DominantPrep
}
