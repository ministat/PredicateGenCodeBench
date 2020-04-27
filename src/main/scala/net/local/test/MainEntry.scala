package net.local.test

import org.apache.spark.sql.catalyst.InternalRow
import org.kohsuke.args4j.{CmdLineException, CmdLineParser, Option}

import scala.collection.JavaConverters._

private[local] class ArgumentsParser{
  @Option(name = "-i", aliases =Array("--iterations"), usage = "Specify the iterations. Default is 99999999")
  var iterations: Long = 99999999

  @Option(name="-c", aliases=Array("--compareResult"), usage="Verify the result of codegen and manual writing code")
  var compareResult: Boolean = false

  def doParse(arguments: Array[String]): Unit = {
    val parser = new CmdLineParser(this)

    try {
      parser.parseArgument(arguments.toList.asJava)
    }
    catch {
      case clEx: CmdLineException =>
        System.out.println("ERROR: Unable to parse command-line options: " + clEx)
    }
  }
}

object MainEntry {
  def perfRun(rowList: Seq[InternalRow], iter: Long, predicate: IPredicateEval): Unit = {
    val start = System.currentTimeMillis()
    for (_ <- 0L until iter) {
      rowList.map(row => predicate.eval(row))
    }
    val dur = System.currentTimeMillis() - start
    println(s"${predicate.name()}: " + dur)
  }

  def main(args: Array[String]): Unit = {
    val argumentsParser = new ArgumentsParser()
    argumentsParser.doParse(args)

    if (argumentsParser.compareResult) {
      val pe = new PredicateEval()
      val mp = new ManualPredicateEval()
      val trueResult = Seq(1L, 2L, 3L, 10L, 11L, 12L, 7, 13, 9, 4L, 5L, 6L, 8, 14, 15, 16)
      val internalRow = InternalRow.fromSeq(trueResult)
      val e1 = pe.eval(internalRow)
      val e2 = mp.eval(internalRow)
      if (e1 != e2) {
        println("Not equal!")
      } else {
        println("Equal!")
      }
    } else {
      val s1 = Seq(1L, 2L, 3L, 10L, 11L, 12L, 7, 13, 9, 4L, 5L, 6L, 8, 14, 15, 16)
      val s2 = Seq(1L, 2L, 3L, 10L, 11L, 12L, 7, 8, 9, 4L, 5L, 6L, 13, 14, 15, 16)
      val s3 = Seq(1L, 2L, 3L, 4L, 11L, 12L, 7, 13, 9, 10L, 5L, 6L, 8, 14, 15, 16)
      val s4 = Seq(1L, 2L, 3L, 4L, 11L, 12L, 7, 13, 9, 10L, 5L, 6L, 8, 14, 15, 16)
      val internalRowSeq = Seq(InternalRow.fromSeq(s1),
        InternalRow.fromSeq(s2),
        InternalRow.fromSeq(s3),
        InternalRow.fromSeq(s4))
      perfRun(internalRowSeq, argumentsParser.iterations, new PredicateEval)
      perfRun(internalRowSeq, argumentsParser.iterations, new ManualPredicateEval)
    }
  }
}
