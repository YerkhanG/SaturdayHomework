package com.example.saturdayhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.saturdayhomework.databinding.ActivitySecondBinding
import android.os.CountDownTimer
class SecondActivity : AppCompatActivity(){
        private lateinit var binding: ActivitySecondBinding
    private lateinit var countDownTimer : CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.extras?.let{
            val name = it.getInt(ArgumentKey.NAME.name)
            binding.countDown.text = getString(R.string.integ,name)
        }
//        countDownTimer = object : CountDownTimer(30000, 1000) {
//
//            override fun onTick(millisUntilFinished: Long) {
//                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000)
//            }
//
//            override fun onFinish() {
//                mTextField.setText("done!")
//            }
//        }.start()
    }
}
//abstract class CountDownTimer(millisInFuture: Long,
//                              countDownInterval: Long)
//}