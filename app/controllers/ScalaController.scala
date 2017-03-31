package controllers
//package scalaguide.sql

import javax.inject.Inject

import play.api.Play.current
import play.api.mvc._
import play.api.db._

class ScalaController @Inject()(db: Database) extends Controller {

  def index(carrier: Option[String]) = Action {
    var outString = s"Pax Count for ${carrier.map(_.toString).getOrElse("")} is "
    val conn = db.getConnection()

    try {
      val stmt = conn.createStatement
      val queryStatement: String = s"SELECT sum(pax_delta) as testkey from nh_ti_vistana_v2_4_p46_od1.booking_ond_activity_carrier_v24 where operating_carrier='${carrier.map(_.toString).getOrElse("")}'"
      println(queryStatement)
      val rs = stmt.executeQuery(queryStatement)

      while (rs.next()) {
        outString += rs.getString("testkey")
      }
    } finally {
      conn.close()
    }
    Ok(outString)
  }

}
