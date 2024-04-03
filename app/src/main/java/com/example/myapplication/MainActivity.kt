package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.time.Year

class MainActivity : AppCompatActivity() {
    enum class HistoricalFigures(val age: Int, val description: String){
        EVENT_1(46, "John F. Kennedy who was the 35th president of the United States of America. He died at the age of 46."),
        EVENT_2(67, "Leonardo Da Vinci who was a famous artist who painted the Mona Lisa in 1503. He died at the age of 67."),
        EVENT_3(39, "Dr Martin luther king jr who was a civil rights activist in the United States. he died at the age of 39."),
        EVENT_4(55, "Julius Caesar who was a roman dictator during his time. He died at the age of 55."),
        EVENT_5(95, "Nelson Mandela who was an anti-apartheid activist and served as the first president of South Africa. He died at the age of 95. "),
        EVENT_6(39, "Cleopatra VII who was the last ruler of the Ptolemaic Kingdom in Egypt and the remnants of her legacy are found in statues across museums. She died at the age of 39. "),
        EVENT_7(76, "Muhammad Ali who was a boxer and an activist who received the title of the greatest heavy weight boxer of all time. He died at the age of 76"),
        EVENT_8(81, "Queen Victoria who was the ruler of Great Britain and ireland from 1837 to 1901. She died at the age of 81."),
        EVENT_9(76, "Albert Einstein who was a German physicist that won a nobel peace prize for his theory of relativity. He died at the age of 76"),
        EVENT_10(20, "Joan of Arc who was a defender of France and later became a military leader despite her being a woman. She died at the age of 20 "),
        EVENT_11(84, "Pope John Paul II who was the sovereign leader of the Vatican city in Rome, Italy. He died at the age of 84"),
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //We declare the variables used in our program.
        val edtAge = findViewById<EditText>(R.id.edtNumber)
        val resultView = findViewById<TextView>(R.id.resultsView)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        //We the add a button to generate the results.
        generateButton?.setOnClickListener()
        {
            //We add a variable for the user's age to allow us to change it from a string to a integer data type.
            val userAge = edtAge.text.toString().toInt()

            //The if statement allows us to check that the user enters the correct range of ages to allow the code to run properly.
            if (userAge != null && userAge in 20..100){

                //We add a variable to pull the historical figures age from our enum class when the user inputs their age.
                val figureAge = HistoricalFigures.values().map { it.age}

                //The when statements runs when the user inputs their age in the edit text.
                val historicalFigure = when (userAge)
                {
                    //The in statement used here runs when the users inputs the same age as one of the historical figures'.
                    in figureAge -> { val history = HistoricalFigures.values().find {it.age == userAge}
                        listOf("You are $userAge years old, the same age as " + "${history?.description?:"event"} ")
                    }

                    //The in statement used here runs when the user inputs an age that's 1 year younger than any historical figures' age.
                    in  figureAge.map {it -1} -> { val history = HistoricalFigures.values().find {it.age == userAge + 1}
                        listOf("You are one year younger than " + "${history?.description?:"event"} ")
                    }

                    //The in statement used here runs when the user inputs an age that's 2 years younger than any historical figures' age.
                    in figureAge.map {it -2} -> { val history = HistoricalFigures.values().find {it.age == userAge + 2}
                        listOf("You are two years younger than " + "${history?.description?:"event"} ")
                    }

                    //
                    in figureAge.map {it -3} -> { val history = HistoricalFigures.values().find {it.age == userAge + 3}
                        listOf("You are three years younger than " + "${history?.description?:"event"} ")
                    }

                    //The in statement used here runs when the user inputs an age that's 1 year older than any historical figures' age.
                    in figureAge.map { it +1} -> { val history = HistoricalFigures.values().find { it.age == userAge - 1}
                        listOf("You are one year older than " + "${history?.description?:"event"} ")
                    }

                    //The in statement used here runs when the user inputs an age that's 2 years older than any historical figures' age.
                    in figureAge.map { it +2} -> { val history = HistoricalFigures.values().find { it.age == userAge - 2}
                        listOf("You are two years older than " + "${history?.description?:"event"} ")
                    }

                    //The in statement used here runs when the user inputs an age that's 3 years older than any historical figures' age.
                    in figureAge.map { it +3} -> { val history = HistoricalFigures.values().find { it.age == userAge - 3}
                        listOf("You are three years older than " + "${history?.description?:"event"} ")
                    }

                    //The else statement runs when the user inputs an age that does not correspond with the in statements used above and displays an error message
                    else -> listOf("There is not historical figure that is $userAge years old. Please enter another age.")

                }

                    resultView.text = historicalFigure.joinToString("\n")


            }

        }

        //The clear button clears the edit text and the text view when pressed but only after the user has inputted a value.
       clearButton?.setOnClickListener {
           edtAge.text.clear()
           resultView.text = ""

       }
    }
}