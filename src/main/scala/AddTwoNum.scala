/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    createNode(sumListMode(l1, l2))
  }

  def sumListMode(l1: ListNode, l2: ListNode, roundedNum: Int = 0, result: Array[Int] = Array[Int]()): Array[Int] = {
    (l1, l2) match {
      case (null, null) => 
        if (roundedNum > 0) result:+ roundedNum
        else result
      case (l1, null) => {
        val acc = l1.x + roundedNum
        sumListMode(l1.next, null, acc / 10, result :+ acc % 10)
      }
      case (null, l2) => {
        val acc = l2.x + roundedNum
        sumListMode(null, l2.next, acc / 10, result :+ acc % 10)
      }
      case (l1, l2)   => {
        val acc = l1.x + l2.x + roundedNum
        sumListMode(l1.next, l2.next, acc / 10, result :+ acc % 10)
      }
    }
  }

  def createNode(arr: Array[Int], ln: ListNode = null): ListNode = {
    if (arr.length == 0) ln
    else new ListNode(arr.head.toInt, createNode(arr.tail, ln))
  }
}
