package utils

import java.io.InputStream

import org.apache.http.HttpEntity
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.methods.{CloseableHttpResponse, HttpGet}
import org.apache.http.impl.client.{CloseableHttpClient, HttpClients}
import org.apache.http.util.EntityUtils

import scala.io.Source

/**
  * @author hanliqiang wrote on 2018/6/12
  */
object HttpUtil {
  var basicUrl = "https://virtserver.swaggerhub.com/Dancuo/SwdBizLog/1.0.0/Info"
  val httpClient: CloseableHttpClient = HttpClients.createDefault()
  val requestConfig: RequestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(1000).setSocketTimeout(5000).build()

  def doGet(param: String): String = {
    val httpGet: HttpGet = new HttpGet(basicUrl + "/" + param)
    httpGet.setConfig(requestConfig)
    val httpResponse: CloseableHttpResponse = httpClient.execute(httpGet)
    val httpEntity: HttpEntity = httpResponse.getEntity
    val inputStream: InputStream = httpEntity.getContent
    //inputStream转化为String
    val content: String = Source.fromInputStream(inputStream).mkString
    val status: Int = httpResponse.getStatusLine.getStatusCode
    println(status)
    //关闭httpResponse中的inputStream
    EntityUtils.consume(httpEntity)
    httpResponse.close()
    content
  }
}
