package controllers

import javax.inject._
import play.api.libs.json.Json.toJson
import play.api.mvc._
import services.MovieService
import services.Formatters._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  val movieService = new MovieService()
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def movies(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    movieService.getMovies().map(movies => Ok(toJson(movies)))
  }

  /**
   * Implement a new endpoint that returns a list of showtimes
   * Implement new model class Showtime which contains a Movie and a list of Screenings
   */
  def showtimes(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    Future.failed(new RuntimeException())
  }
}
