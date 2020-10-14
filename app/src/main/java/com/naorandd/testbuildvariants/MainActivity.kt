package com.naorandd.testbuildvariants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * BuildTypeごとに処理が違うことを確認するアプリ
 *
 * レイアウト上のTextViewとButtonはリソースをビルドタイプごとに分岐
 * トースト表示はコード上のBuildConfigを取得して処理を分岐
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        // BuildTypeをBuildConfigから取得
        val buildType : Boolean = BuildConfig.BUILD_TYPE == "debug"

        // BuildTypeによってコード上から処理を分岐
        button.setOnClickListener {
                showToast(buildType)
        }
    }

    private fun showToast(type: Boolean){
        // type = true　つまり、Debugモードによるビルド
        if(type){
            Toast.makeText(applicationContext, "Debugモードです", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext, "Releaseモードです", Toast.LENGTH_LONG).show()
        }
    }
}