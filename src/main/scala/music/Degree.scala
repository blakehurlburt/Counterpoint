package music

/**
 * Type that describes scale degrees
 * Used in Note and Chord
 */
sealed trait Degree
case object One   extends Degree
case object Two   extends Degree
case object Three extends Degree
case object Four  extends Degree
case object Five  extends Degree
case object Six   extends Degree
case object Seven extends Degree
