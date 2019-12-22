package mvp

import bean.RegisterBean

/**
 * author: 栗铃涵
 * data: 2019/12/20 20:20:51
 * function
 */
interface CallBack1 {
    fun Desuccess(registerBean: RegisterBean)
    fun Error(error:String)
}