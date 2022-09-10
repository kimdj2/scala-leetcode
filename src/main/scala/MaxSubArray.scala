object Solution {
  def maxSubArray(nums: Array[Int]): Int = 
    nums.foldLeft((0,Int.MinValue))((acc, num) => {
      val sum = acc._1 + num
      val max = scala.math.max(acc._2, sum)
      if (sum < 0) (0, max)
      else (sum, max)
    })._2
}
