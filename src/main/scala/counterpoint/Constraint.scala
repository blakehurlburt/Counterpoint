package counterpoint

sealed trait Result
case object Success extends Result
final case class Failure(reason: String) extends Result

object Constraint {
    type Constraint = Problem => Result

    

    var constraints = Seq[Constraint]()
}
