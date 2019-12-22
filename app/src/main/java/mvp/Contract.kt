package mvp

import bean.LoginBean

/**
 * author: 栗铃涵
 * data: 2019/12/21 09:9:47
 * function
 */
interface Contract {
    interface IModel{
        fun getModel1(phone:String,pwd:String,callBack: CallBack)
    }
    abstract class IPresenter{
        abstract fun getPresenter(phone: String,pwd: String)
    }
    interface IView{
        fun Desuccess(loginBean: LoginBean)
        fun Error(ememme:String)
    }
}