package utils

import android.app.Application
import android.content.Context

/**
 * author: 栗铃涵
 * data: 2019/12/20 20:20:34
 * function
 */
class BaseApplication : Application(){
    companion object{
        lateinit var mcontent: Context
        fun getContent():Context{
            return mcontent;
        }
    }
    override fun onCreate(){
        super.onCreate()
        mcontent=this
    }
}