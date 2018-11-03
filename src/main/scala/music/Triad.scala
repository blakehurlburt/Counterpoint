package music

object Triad {
    sealed trait Quality {
        def I   = Triad(this, music.One,   Root)
        def II  = Triad(this, music.Two,   Root)
        def III = Triad(this, music.Three, Root)
        def IV  = Triad(this, music.Four,  Root)
        def V   = Triad(this, music.Five,  Root)
        def VI  = Triad(this, music.Six,   Root)
        def VII = Triad(this, music.Seven, Root)

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

sealed trait Inversion

case object Root   extends Inversion
case object First  extends Inversion
case object Second extends Inversion

final case class Triad(quality: Quality, root: Degree, inversion: Inversion) {
    def + =   Triad(Augmented,  root, inversion)
    def m =   Triad(Minor,      root, inversion)
    def M =   Triad(Major,      root, inversion)
    def dim = Triad(Diminished, root, inversion)

    def Root   = Triad(quality, root, music.Root)
    def First  = Triad(quality, root, music.First)
    def Second = Triad(quality, root, music.Second)
}
