package com.example.saturdayhomework

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.saturdayhomework.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpSayHelloButton()
        setUpSendTextButton()
    }
    private fun setUpSayHelloButton(){
        binding.sayHello.setOnClickListener{
            if(isValid()){
                val intent = Intent(this , SecondActivity::class.java)
                intent.putExtra(ArgumentKey.NAME.name , binding.inputMain.text.toString())
                startActivity(intent)
            }else Toast.makeText(this , "You need to input some number!" , Toast.LENGTH_SHORT).show()
        }
    }
    private fun setUpSendTextButton(){
        binding.sendText.setOnClickListener{
            if(isValid()){
                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_TEXT, binding.inputMain.text.toString())
                intent.type = "text/plain"
                val chooseIntent = Intent.createChooser(intent,"Title")
                startActivity(chooseIntent)
            }else Toast.makeText(this , "You need to input some number!" , Toast.LENGTH_SHORT).show()
        }
    }
    private fun isValid() = !binding.inputMain.text.isNullOrBlank()

}
enum class ArgumentKey{
    NAME
}