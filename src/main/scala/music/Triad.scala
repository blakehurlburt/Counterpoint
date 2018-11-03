package music

object Triad {
    sealed trait Quality {
        def I   = Triad(this, music.One, music.Three, music.Five)
        def II  = Triad(this, music.Two, music.Four, music.Six)
        def III = Triad(this, music.Three, music.Five, music.Seven)
        def IV  = Triad(this, music.Four, music.Six, music.One)
        def V   = Triad(this, music.Five, music.Seven, music.Two)
        def VI  = Triad(this, music.Six, music.One, music.Three)
        def VII = Triad(this, music.Seven, music.Two, music.Four)

        def One   = I
        def Two   = II
        def Three = III
        def Four  = IV
        def Five  = V
        def Six   = VI
        def Seven = VII

        def i   = I
        def ii  = II
        def iii = III
        def iv  = IV
        def v   = V
        def vi  = VI
        def vii = VII
    }

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
}

import Triad.Quality

case object Diminished extends Quality
case object Minor      extends Quality
case object Major      extends Quality
case object Augmented  extends Quality

final case class Triad(quality: Quality, root: Degree, third: Degree, fifth: Degree) {
    def + = Triad(Augmented, root, third, fifth)
    def m = Triad(Minor, root, third, fifth)
    def M = Triad(Major, root, third, fifth)
    def dim = Triad(Diminished, root, third, fifth)
}
