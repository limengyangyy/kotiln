package mvp

import bean.RegisterBean

/**
 * author: 栗铃涵
 * data: 2019/12/20 20:20:40
 * function
 */
interface Contract1 {
    interface IModel{
        fun getmodel(phone :String,nickName:String,pwd :String,callback1: CallBack1)
    }
    abstract class IPresenter{
        abstract fun getrpesenter(phone: String,nickName: String,pwd: String)
    }
    interface IView{
        fun Desuccess(registerBean: RegisterBean);
        fun Error(ememme:String)
    }
}