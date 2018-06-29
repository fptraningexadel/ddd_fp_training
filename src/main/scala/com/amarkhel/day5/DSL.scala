package com.amarkhel.day5

object DSL2 {
  implicit class StringImprovements(s: String) {
    def increment = s.map(c => (c + 1).toChar)
  }
  import dsl._

  def main(args: Array[String]) = {
    val biweeklyDeductions = biweekly { deduct =>
      deduct federal_tax          (25.0  percent)
      deduct state_tax            (5.0   percent)
      deduct insurance_premiums   (500.0 dollars)
      deduct retirement_savings   (10.0  percent)
    }

    println(biweeklyDeductions)
    val annualGross = 100000.0
    val gross = biweeklyDeductions.gross(annualGross)
    val net   = biweeklyDeductions.net(annualGross)
    print(f"Biweekly pay (annual: $$${annualGross}%.2f): ")
    println(f"Gross: $$${gross}%.2f, Net: $$${net}%.2f")
  }
}

object dsl {

  def biweekly(f: DeductionsBuilder => Deductions) =
    f(new DeductionsBuilder("Biweekly", 26.0))

  class DeductionsBuilder(name: String, divisor: Double = 1.0,
     deducts: Vector[Deduction] = Vector.empty) extends Deductions(name, divisor, deducts) {

    def federal_tax(amount: Amount): DeductionsBuilder = {
      deductions = deductions :+ Deduction("federal taxes", amount)
      this
    }

    def state_tax(amount: Amount): DeductionsBuilder = {
      deductions = deductions :+ Deduction("state taxes", amount)
      this
    }

    def insurance_premiums(amount: Amount): DeductionsBuilder = {
      deductions = deductions :+ Deduction("insurance premiums", amount)
      this
    }

    def retirement_savings(amount: Amount): DeductionsBuilder = {
      deductions = deductions :+ Deduction("retirement savings", amount)
      this
    }
  }
    sealed trait Amount { def amount: Double }

    case class Percentage(amount: Double) extends Amount {
      override def toString = s"$amount%"
    }

    case class Dollars(amount: Double) extends Amount {
      override def toString = s"$$$amount"
    }

    implicit class Units(amount: Double) {
      def percent = Percentage(amount)
      def dollars = Dollars(amount)
    }

    case class Deduction(name: String, amount: Amount) {
      override def toString = s"$name: $amount"
    }

    case class Deductions(name: String, divisorFromAnnualPay: Double = 1.0, var deductions: Vector[Deduction] = Vector.empty) {

      def gross(annualSalary: Double): Double =
        annualSalary / divisorFromAnnualPay

      def net(annualSalary: Double): Double = {
        val g = gross(annualSalary)
        (deductions foldLeft g) {
          case (total, Deduction(_, amount)) => amount match {
            case Percentage(value) => total - (g * value / 100.0)
            case Dollars(value) => total - value
          }
        }
      }

      override def toString = s"$name Deductions:" + deductions.mkString("\n  ", "\n  ", "")
  }
}
