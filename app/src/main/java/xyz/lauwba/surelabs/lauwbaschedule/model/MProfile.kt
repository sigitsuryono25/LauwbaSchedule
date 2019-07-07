@file:Suppress("DEPRECATION")

package xyz.lauwba.surelabs.lauwbaschedule.model

import android.app.ProgressDialog
import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.lauwba.surelabs.lauwbaschedule.controller.IProfile
import xyz.lauwba.surelabs.lauwbaschedule.model.data.profile.ProfileModel
import xyz.lauwba.surelabs.lauwbaschedule.model.data.profile.ProfileModelResponse
import xyz.lauwba.surelabs.lauwbaschedule.network.NetworkModule
import xyz.lauwba.surelabs.lauwbaschedule.view.IProfileView

class MProfile(private val context: Context?, private val iProfile: IProfileView) : IProfile {

    private var pd: ProgressDialog? = null

    override fun onUpdateDataOff(models: ProfileModel?) {

    }

    override fun getProfileData(username: String?) {
        pd = ProgressDialog.show(context, "", "Sending data...")
        NetworkModule.getService().goGetProfile(username)
            .enqueue(object : Callback<ProfileModelResponse> {
                override fun onFailure(call: Call<ProfileModelResponse>, t: Throwable) {
                    pd?.dismiss()
                    iProfile.onLoadDataFailed(t.message.toString())
                }

                override fun onResponse(
                    call: Call<ProfileModelResponse>,
                    response: Response<ProfileModelResponse>
                ) {
                    pd?.dismiss()
                    if (response.isSuccessful) {
                        val status = response.body()?.status
                        val message = response.body()?.message
                        if (status == 200) {
                            iProfile.onLoadDataSuccess(response.body()?.data)
                        } else {
                            iProfile.onLoadDataFailed(message)
                        }
                    } else {
                        iProfile.onLoadDataFailed(response.errorBody().toString())
                    }
                }

            })
    }
}