package dao



import scala.concurrent.Future
import play.api.Play.current
import play.api.db.DB
import javax.inject.Inject
import model.{UserInfo}
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile
class UserInfoDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {
  import driver.api._
  private val userInfos = TableQuery[UserInfoTable]

  def all(): Future[Seq[UserInfo]] = db.run(userInfos.result)

  def insert(userInfo: UserInfo): Future[Unit] = db.run(userInfos += userInfo).map { _ => () }

  private class UserInfoTable(tag: Tag) extends Table[UserInfo](tag, "userinfo") {

    def name = column[String]("name")
    def lastname = column[String]("lastname")
    def email = column[String]("email")
    def phone = column[String]("phone")
    def photo = column[Option[String]]("photo")
    def website = column[Option[String]]("website")
    def notes = column[Option[String]]("notes")

    def * = (name, lastname,email,phone,photo,website,notes) <> (UserInfo.tupled, UserInfo.unapply _)


  }


}