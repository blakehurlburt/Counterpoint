package music.triad

sealed trait Quality {
    def I   = Triad(this, music.One)
    def II  = Triad(this, music.Two)
    def III = Triad(this, music.Three)
    def IV  = Triad(this, music.Four)
    def V   = Triad(this, music.Five)
    def VI  = Triad(this, music.Six)
    def VII = Triad(this, music.Seven)

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

case object Diminished extends Quality
case object Minor      extends Quality
case object Major      extends Quality
case object Augmented  extends Quality
