package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            cal(it)
        }
    }

    private fun cal(view:View){
        val carPrice :String = findViewById<EditText>(R.id.editTextCarPrice).text.toString()
        val downPaymentAmount :String = findViewById<EditText>(R.id.editTextDownPayment).text.toString()
        val loanPeriod :String = findViewById<EditText>(R.id.editTextLoanPeriod).text.toString()
        val interestRate :String = findViewById<EditText>(R.id.editTextInterestRate).text.toString()


        val carLoan :Double = carPrice.toDouble() - downPaymentAmount.toDouble()
        val interest = carLoan * interestRate.toDouble() * loanPeriod.toDouble()
        val repayment = (carLoan + interest) / loanPeriod.toDouble() / 12

        textViewLoan.text = "Car Loan = RM%.2f".format(carLoan).toString()
        textViewInterest.text =  "Interest = RM%.2f".format(interest).toString()
        textViewMonthlyRepayment.text = "Monthly Repayment = RM%.2f".format(repayment).toString()

    }


}
