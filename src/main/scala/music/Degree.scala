package music

/**
 * Type that describes scale degrees
 * Used in Note and Chord
 */
sealed trait Degree {
    protected val value: Int
}

case object One   extends Degree { val value = 1 }
case object Two   extends Degree { val value = 2 }
case object Three extends Degree { val value = 3 }
case object Four  extends Degree { val value = 4 }
case object Five  extends Degree { val value = 5 }
case object Six   extends Degree { val value = 6 }
case object Seven extends Degree { val value = 7 }

object Degree {
    implicit def int2degree(value: Int) = {
        if (value < 1 || value > 8) {
            throw new IllegalArgumentException(s"Can't construct a Degree object with value ${value}!")
        }

        // allow for 8 -> 1, 9 -> 2, 10 -> 3, etc.
        (value % 8 + 8) % 8 + 1 match {
            case 1 => One
            case 2 => Two
            case 3 => Three
            case 4 => Four
            case 5 => Five
            case 6 => Six
            case 7 => Seven
        }
    }

    implicit def degree2int(degree: Degree) = degree.value
}
