package e.joon2.travel_mate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_join.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.*
import javax.net.ssl.HttpsURLConnection

class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
    }

 /*   fun onButtonJClicked(v: View){
        try{
            val url = URL("https://www.naver.com")
            val con = url.openConnection() as HttpURLConnection
            con.requestMethod = "GET"
            con.connectTimeout = 2000
            con.useCaches = false

//            val responseCode = con.responseCode
//            val responseMessage = con.responseMessage

            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
            System.out.println(con.responseCode)
//            System.out.println(responseMessage)
//
//
//
//            if (responseCode == 200){
//                System.out.println("success")
//                System.out.println(responseMessage)
//            }else {
//                System.out.println("fails")
//            }
        }catch(e: IOException){
            e.message
        }

    }

*/
}
