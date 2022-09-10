import scala.collection.mutable

object Solution {
  def generateParenthesis(n: Int): List[String] = {
    val parentheses = Array.fill[String](n)("(") ++ Array.fill[String](n)(")")
    parentheses.permutations.filter(_.head == "(").filter(check).toList.map(_.mkString)
  }

  def check(list: Array[String]): Boolean = {
    val stk = mutable.Stack[String]()
    var result = true
    for (
      s <- list if result
    ){
      if (s == ")" && stk.size == 0) result = false
      else if (s == ")") stk.pop()
      else stk.push("(")
    }
    result
  }
}
