package music.note

sealed trait Quality {
    def One   = Note(music.One,   this)
    def Two   = Note(music.Two,   this)
    def Three = Note(music.Three, this)
    def Four  = Note(music.Four,  this)
    def Five  = Note(music.Five,  this)
    def Six   = Note(music.Six,   this)
    def Seven = Note(music.Seven, this)
}

case object Natural extends Quality
case object Flat    extends Quality
case object Sharp   extends Quality
case object DoubleFlat extends Quality
case object DoubleSharp extends Quality
