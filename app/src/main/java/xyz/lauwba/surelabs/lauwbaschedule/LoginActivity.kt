package xyz.lauwba.surelabs.lauwbaschedule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import xyz.lauwba.surelabs.lauwbaschedule.controller.ILogin
import xyz.lauwba.surelabs.lauwbaschedule.library.SecurePreferences
import xyz.lauwba.surelabs.lauwbaschedule.model.MLogin
import xyz.lauwba.surelabs.lauwbaschedule.model.data.login.LoginModel
import xyz.lauwba.surelabs.lauwbaschedule.view.ILoginView

class LoginActivity : AppCompatActivity(), ILoginView {
    private var mILogin: ILogin? = null
    private var s: SecurePreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //init securepref
        s = SecurePreferences(this, "asiyaaaaaapppppp", true)
        if (s?.isContainingKey == true) {
            startActivity<MainActivity>()
            return
        }
        setContentView(R.layout.activity_login)

        loginBtn.onClick {
            if (username.text?.isEmpty() == true) {
                username.error = "Wajib Diisi"
            } else if (password.text?.isEmpty() == true) {
                password.error = "Wajib Diisi"
            } else {
                setupLogin(username.text.toString(), password.text.toString())
            }
        }
    }

    private fun setupLogin(username: String, password: String) {
        mILogin = MLogin(this, this)
        mILogin?.sendCredentials(username, password)
    }

    override fun onFailure(message: String?) {
        toast(message.toString())
    }

    override fun onLoginSuccess(models: LoginModel?) {
        toast(getString(R.string.welcome, models?.username.toString()))
        s?.put("username", models?.username ?: "")
        startActivity<MainActivity>()
    }
}
