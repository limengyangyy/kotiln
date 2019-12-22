package com.wd.kj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import bean.RegisterBean
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_regist.*
import mvp.Contract1
import mvp.RegisterPresenter

class RegistActivity : AppCompatActivity() ,Contract1.IView{
    private var  presenter : RegisterPresenter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        presenter= RegisterPresenter(this);
        btn_regist!!.setOnClickListener {
            val phone =  edit_phone_regist.text.toString();
            val name = edit_name_regist.text.toString();
            val pwd =  edit_pwd_regist.text.toString();
            if (phone.equals("") || name.equals("") || pwd.equals("")){

            }else{
                val byPublicKey = RsaCoder.encryptByPublicKey(pwd);
                presenter!!.getrpesenter(phone,pwd,byPublicKey)
            }
        }
    }
    override fun Desuccess(registerBean: RegisterBean) {
        val bean = registerBean as RegisterBean;
        val message = bean.message;
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        if (registerBean!!.status.equals("1001")){
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent)
        }
    }

    override fun Error(ememme: String) {
    }

}
