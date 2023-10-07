package com.example.saturdayhomework

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.saturdayhomework.databinding.ActivitySecondBinding
import android.os.CountDownTimer
import android.widget.Toast
import java.util.Locale


class SecondActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySecondBinding
    private lateinit var countDownTimer : CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.extras?.let{
            val name = it.getString(ArgumentKey.NAME.name)
            binding.countDown.text = getString(R.string.integ , name)
        }
        var counter: Long = binding.countDown.text.toString().toLong()
        var prev = counter
        with(binding){
            startButton.setOnClickListener(){
                countDownTimer = object : CountDownTimer(counter * 1000, 1000) {

                    override fun onTick(millisUntilFinished: Long) {
                        counter--
                        binding.countDown.text = String.format(Locale.getDefault(),"%d",counter)
                    }

                    override fun onFinish() {
                        Toast.makeText(parent,"FINISHED!!!",Toast.LENGTH_SHORT).show()
                    }
                }.start()

            }
            pauseButton.setOnClickListener(){
                countDownTimer.cancel()
            }
            resetButton.setOnClickListener(){
                binding.countDown.text = prev.toString()
                counter = prev
                countDownTimer.cancel()
            }

        }

    }
}

//abstract class CountDownTimer(millisInFuture: Long,
//                              countDownInterval: Long)
//}
