@file:Suppress("DEPRECATION")

package xyz.lauwba.surelabs.lauwbaschedule.model

import android.app.ProgressDialog
import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.lauwba.surelabs.lauwbaschedule.controller.ILogin
import xyz.lauwba.surelabs.lauwbaschedule.model.data.login.LoginModelResponse
import xyz.lauwba.surelabs.lauwbaschedule.network.NetworkModule
import xyz.lauwba.surelabs.lauwbaschedule.view.ILoginView

class MLogin(private val context: Context?, private val iLoginView: ILoginView) : ILogin {
    private var pd: ProgressDialog? = null


    override fun sendCredentials(username: String?, pswd: String?) {
        pd = ProgressDialog.show(context, "", "Sedang melakukan pengecekan....")
        NetworkModule.getService().goLogin(username, pswd)
            .enqueue(object : Callback<LoginModelResponse> {
                override fun onFailure(call: Call<LoginModelResponse>, t: Throwable) {
                    pd?.dismiss()
                    iLoginView.onFailure(t.message.toString())
                }

                override fun onResponse(
                    call: Call<LoginModelResponse>,
                    response: Response<LoginModelResponse>
                ) {
                    pd?.dismiss()
                    if (response.isSuccessful) {
                        val message = response.body()?.message
                        val status = response.body()?.status
                        if (status == 200) {
                            iLoginView.onLoginSuccess(response.body()?.data)
                        } else {
                            iLoginView.onFailure(message)
                        }

                    } else {
                        val message = response.errorBody().toString()
                        iLoginView.onFailure(message)
                    }
                }
            })
    }

}