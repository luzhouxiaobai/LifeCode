import org.apache.flink.api.common.functions.MapFunction
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}

object DataTest {
  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val dataStream = env.fromElements("hello", "world")
    dataStream.map(new MyMapFunction).print()

    env.execute("T")

  }
}

class MyMapFunction extends MapFunction[String, String] {
  override def map(value: String): String = value.toUpperCase()
}
