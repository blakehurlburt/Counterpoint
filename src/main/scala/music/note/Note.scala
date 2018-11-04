package music.note

import music.Degree

final case class Note(degree: Degree, quality: Quality = Natural)

object implicits {
    implicit def degree2note(degree: Degree) = Note(degree)
}
