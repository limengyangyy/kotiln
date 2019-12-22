package mvp

import bean.RegisterBean
import com.wd.kj.RegistActivity

/**
 * author: 栗铃涵
 * data: 2019/12/22 18:18:47
 * function
 */
class RegisterPresenter (IView:RegistActivity):Contract1.IPresenter(){
    private var iView : Contract1.IView ?= null
    private var model : RegisterUtils ? =null
    init {
        this.iView =iView
        model = RegisterUtils()
    }
    override fun getrpesenter(phone: String, nickName: String, pwd: String) {
        model!!.getmodel(phone,pwd,nickName,object :CallBack1{
            override fun Desuccess(registerBean: RegisterBean) {
                if (iView !=null){
                    iView!!.Desuccess(registerBean)
                }
            }

            override fun Error(error: String) {
            }

        })
    }
}