import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}

object WordCount {

  def main(args: Array[String]) : Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val text = env.fromElements( "DDD Test")
    text.flatMap(_.split(" "))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(0)
      .sum(1)
      .print()

    env.execute("Word Count Start")
  }

}
