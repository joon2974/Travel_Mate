package e.joon2.travel_mate

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_join.*
import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        //회원가입 버튼을 클릭했을 때 서버와 연결
        join.setOnClickListener{
            //임의로 제시한 api
            val url = "http://omnic-environment.ap-northeast-2.elasticbeanstalk.com/orders/options?link_url=http://m.black-up.kr/product/detail.html?product_no=10379%26cate_no=1%26display_group=2"
            HttpConnect().execute(url)
        }
    }

    //메인스레드에서 연결작업 처리시 작업 처리중 다른 작업 처리 불가: 비동기식 처리
    inner class HttpConnect : AsyncTask<String, String, String>(){

        override fun onPreExecute(){

        }

        override fun doInBackground(vararg urls: String?): String {
            val urlConnection: HttpURLConnection? = null

            try{
                //parameter로 넘어온 url을 매개로 연결
                val url = URL(urls[0])

                //url 연결까진 성공, 데이터 전송 방식 GET, POST등의 방식을 활용하는 것 추가해야함
                val urlConnection = url.openConnection() as HttpURLConnection
                //urlConnection.requestMethod("GET")
                urlConnection.connectTimeout = 5000
                urlConnection.readTimeout = 5000
                //urlConnection.connect()

                //api에서 정보를 받음
                var inString = streamToString(urlConnection.inputStream)

                //받은 jsom을 파싱
                try{

                    var json = JSONObject(inString)
                    val color = json.getJSONArray("color")

                    /*Log.i("jsonvalue",color.toString())
                    Log.i("color1",color[0].toString())
                    Log.i("color2",color[1].toString())
                    */

                    inString =
                            "color1:" + color[0].toString() +
                            "color2:" + color[1].toString() +
                            "color3:" + color[2].toString() +
                            "color4:" + color[3].toString() +
                            "color5:" + color[4].toString()
                    //Log.i("text",tv.toString())
                } catch (ex: Exception){

                }


                tv.setText(inString)


            } catch(ex: Exception){

            } finally{
                if(urlConnection != null){
                    urlConnection.disconnect()
                }
            }
            return " "
        }

        override fun onProgressUpdate(vararg values: String?) {
            //Done

        }

        override fun onPostExecute(result: String?) {
            //Done
        }

        //api에서 정보를 받아오는 메소드, 원리 이해 필요
        fun streamToString(inputStream: InputStream): String{
            val bufferdReader = BufferedReader(InputStreamReader(inputStream))
            var line: String
            var result = " "

            try{
                do{
                    line = bufferdReader.readLine()
                    if(line != null){
                        result += line
                    }
                }while(line != null)
                inputStream.close()
            } catch(ex: Exception){

            }
            return  result
        }
    }

}
