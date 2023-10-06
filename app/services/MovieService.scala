package services

import play.api.libs.json.{Format, Json}

import java.time.Instant
import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

case class Movie(id: UUID, title: String)

case class Screening(id: UUID, movieId: UUID, time: Instant)

object Formatters {
  implicit val movieFormat: Format[Movie] = Json.format[Movie]
  implicit val screeningFormat: Format[Screening] = Json.format[Screening]
}

class MovieService {

  private val MOVIE_LIST = Seq(Movie(UUID.randomUUID(), "Citizen Kane"), Movie(UUID.randomUUID(), "Bambi"))
  private val SCREENINGS = Seq(
    Screening(
      UUID.randomUUID(),
      MOVIE_LIST(0).id,
      Instant.now()
    ),
    Screening(
      UUID.randomUUID(),
      MOVIE_LIST(0).id,
      Instant.now()
    ),
    Screening(
      UUID.randomUUID(),
      MOVIE_LIST(0).id,
      Instant.now()
    ),
    Screening(
      UUID.randomUUID(),
      MOVIE_LIST(1).id,
      Instant.now()
    ),
    Screening(
      UUID.randomUUID(),
      MOVIE_LIST(1).id,
      Instant.now()
    )
  )

  def getMovies(): Future[Seq[Movie]] = {
    Future(MOVIE_LIST)
  }

  def getScreenings(): Future[Seq[Screening]] = {
    Future(SCREENINGS)
  }

}
