package music

object Note {
    sealed trait Quality {
        def One   = Note(music.One,   this)
        def Two   = Note(music.Two,   this)
        def Three = Note(music.Three, this)
        def Four  = Note(music.Four,  this)
        def Five  = Note(music.Five,  this)
        def Six   = Note(music.Six,   this)
        def Seven = Note(music.Seven, this)
    }
}

import Note.Quality

case object Natural extends Quality
case object Flat    extends Quality
case object Sharp   extends Quality

final case class Note(degree: Degree, quality: Note.Quality = Natural)

object implicits {
    implicit def degree2note(degree: Degree) = Note(degree)
}
