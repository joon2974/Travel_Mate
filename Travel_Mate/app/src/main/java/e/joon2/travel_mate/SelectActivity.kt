package e.joon2.travel_mate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
    }

    fun onButton2Clicked(v : View){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
