/**
 * @author ouertani@gmail.com
 * Date: 24/11/2013
 */

import controllers.routes
import play.api._
import mvc.RequestHeader
import java.net._

object Global extends GlobalSettings {
  override def onRouteRequest(req: RequestHeader) = {
    import rww.play.EnhancedRequestHeader

    val uri = req.getAbsoluteURI



    if (uri.getHost != "localhost") {
      req.method match {
        case "GET" => Some(controllers.ReadWriteWebApp.get(req.path))
        case "POST" => Some(controllers.ReadWriteWebApp.post(req.path))
        case "PATCH" => Some(controllers.ReadWriteWebApp.patch(req.path))
        case "MKCOL" => Some(controllers.ReadWriteWebApp.mkcol(req.path))
        case "DELETE" => Some(controllers.ReadWriteWebApp.delete(req.path))

      }
    } else  super.onRouteRequest(req)
  }
}
