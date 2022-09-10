object Solution {
  def isPalindrome(x: Int): Boolean = {
    val xStr = x.toString
    xStr == xStr.split("").reverse.mkString
  }
}
