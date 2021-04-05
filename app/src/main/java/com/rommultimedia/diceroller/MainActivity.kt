package com.rommultimedia.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton1: Button = findViewById(R.id.button)
        rollButton1.setOnClickListener {
            rollDice()
        }
        rollDice()
    }

    private fun rollDice() {
        // Create new Die with 6 sides
        val dice = Dice(6)
        // Assign diceRoll method to variable
        val diceRoll = dice.roll()
        //select imageView
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.contentDescription = diceRoll.toString()
        // assing resource image id name to imageView resource
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // set corresponding image to roll result
        diceImage.setImageResource(drawableResource)


    }
}

class Dice(val numSides: Int) {
    //Generate pseudo-random number representing the resulting face of the die
    fun roll(): Int {
        return (1..numSides).random()
    }

}