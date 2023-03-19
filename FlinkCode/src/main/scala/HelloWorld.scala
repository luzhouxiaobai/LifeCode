import org.apache.flink.api.scala.{ExecutionEnvironment, createTypeInformation}

object HelloWorld {

  def main(args: Array[String]): Unit = {

    val benv = ExecutionEnvironment.getExecutionEnvironment
    val textBatch = benv.fromElements("To be, or not to be, --that is the questions:--",
     "Whether 'tis no in te mind is suffer")

    textBatch.flatMap(_.toLowerCase.split("\\W+")).map((_, 1)).groupBy(0).sum(1).print()
  }

}
