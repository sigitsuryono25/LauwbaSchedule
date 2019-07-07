package xyz.lauwba.surelabs.lauwbaschedule.model

import android.app.ProgressDialog
import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.lauwba.surelabs.lauwbaschedule.controller.IOverViewSchedule
import xyz.lauwba.surelabs.lauwbaschedule.model.data.EventModelResponse
import xyz.lauwba.surelabs.lauwbaschedule.network.NetworkModule
import xyz.lauwba.surelabs.lauwbaschedule.view.IOverView

class MEvent(private val context: Context?, private val iOverView: IOverView) : IOverViewSchedule {
    override fun getListEvent() {
        getListData()
    }

    private var pd: ProgressDialog? = null

    fun getListData() {
        pd = ProgressDialog.show(context, "", "Get Event LoginModel")
        NetworkModule.getService().goGetListData()
            .enqueue(object : Callback<EventModelResponse> {
                override fun onFailure(call: Call<EventModelResponse>, t: Throwable) {
                    iOverView.onError(t.message)
                }

                override fun onResponse(
                    call: Call<EventModelResponse>, response: Response<EventModelResponse>
                ) {
                    pd?.dismiss()
                    if (response.isSuccessful) {
                        val code = response.body()?.status
                        if (code == 200) {
                            val data = response.body()?.data
                            iOverView.eventExist(data)
                        } else {
                            iOverView.eventNotExist(response.body())
                        }
                    } else {

                    }
                }

            })
    }


}