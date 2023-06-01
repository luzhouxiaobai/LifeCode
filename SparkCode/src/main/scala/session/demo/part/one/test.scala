package session.demo.part.one

import org.apache.spark.sql.SparkSession

object test {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().master("local").enableHiveSupport().getOrCreate()

    val myRanges = spark.range(100).toDF()

    val part1 = spark.sparkContext.textFile("/opt/bitnami/spark/README.md", 6)
    part1.partitions
    for (tok <- part1) {
      print(tok)
    }

    part1.dependencies

    myRanges.show()

    print(myRanges.count())

    val fightData2015 = spark.read
      .option("inferSchema", "true")
      .option("header", "true")
      .csv("D:\\code\\DataCode\\file\\fightdata2015.csv")

    fightData2015.show(10)
    fightData2015.printSchema()
    fightData2015.sort("count").explain()



  }

}
