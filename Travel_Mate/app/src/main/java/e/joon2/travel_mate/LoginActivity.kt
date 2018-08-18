package e.joon2.travel_mate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onButton1Clicked(v : View){
        val intent = Intent(this, JoinActivity::class.java)
        startActivity(intent)
    }
}
