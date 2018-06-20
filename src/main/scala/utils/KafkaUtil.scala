package utils
import java.util.Properties

import org.apache.kafka.clients.producer.KafkaProducer

/**
  * @author hanliqiang wrote on 2018/6/11
  */
object KafkaUtil extends Config {
  def createProducer(): KafkaProducer[String, String] = {
    val props = new Properties()

    props.put("bootstrap.servers", "10.90.1.191:9092");
//    props.put("bootstrap.servers","127.0.0.1:9092");
    props.put("request.required.acks", "1")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("group.id", "test");
    props.put("auto.offset.reset", "largest");
    new KafkaProducer[String, String](props)
  }
}
