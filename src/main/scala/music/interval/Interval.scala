package music.interval

import music._

case class Interval(quality: Quality, degree: Degree) {
    require((Interval.canBePerfect contains degree) &&
           !(Seq(Major, Minor) contains quality),
           s"No such thing as a ${quality} ${degree}!")
}

object Interval {
    private val canBePerfect = Seq(Four, Five, One)
}
