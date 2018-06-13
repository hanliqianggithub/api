package utils

import com.typesafe.config.ConfigFactory

/**
  * @author hanliqiang wrote on 2018/6/6
  */
trait Config {
  private val config = ConfigFactory.load()
  private val httpConfig = config.getConfig("http")
  val httpInterface = httpConfig.getString("interface")
  val httpPort = httpConfig.getInt("port")
}
