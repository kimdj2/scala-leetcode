object Solution {
  def convert(s: String, numRows: Int): String = {
    val sArr = s.split("")
    sArr.foldLeft((0, 0, Seq.fill(numRows)(Seq[String]())))((acc, s) => {
      val maxVal = 2 * numRows - 2
      if (acc._1 == maxVal - 1 || maxVal == 0) 
        (0, 0, acc._3.updated(acc._2, acc._3(acc._2) :+ s))
      else if (acc._1 >= numRows - 1) 
        (acc._1 + 1, acc._2 - 1, acc._3.updated(acc._2, acc._3(acc._2) :+ s))
      else {
        (acc._1 + 1, acc._2 + 1, acc._3.updated(acc._2, acc._3(acc._2) :+ s))
      }
    })._3.flatten.mkString
  }
}
