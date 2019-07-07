@file:Suppress("DEPRECATION")

package xyz.lauwba.surelabs.lauwbaschedule.model

import android.app.ProgressDialog
import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.lauwba.surelabs.lauwbaschedule.controller.IAddSchedule
import xyz.lauwba.surelabs.lauwbaschedule.model.data.tambah.CUDResponse
import xyz.lauwba.surelabs.lauwbaschedule.model.data.tambah.TambahModel
import xyz.lauwba.surelabs.lauwbaschedule.network.NetworkModule
import xyz.lauwba.surelabs.lauwbaschedule.view.IAddScheduleView

class MAddSchedule(
    private val context: Context?,
    private val iTambahJadwalView: IAddScheduleView
) : IAddSchedule {

    private var pd: ProgressDialog? = null

    override fun sendSchedule(models: TambahModel) {
        pd = ProgressDialog.show(context, "", "Sending data....")
        NetworkModule.getService().goPutEvent(
            models.username, models.startDate, models.endDate, models.eventName, models.kind
        )
            .enqueue(object : Callback<CUDResponse> {
                override fun onFailure(call: Call<CUDResponse>, t: Throwable) {
                    pd?.dismiss()
                    iTambahJadwalView.onSendDataFailed(t.message.toString())
                }

                override fun onResponse(call: Call<CUDResponse>, response: Response<CUDResponse>) {
                    pd?.dismiss()
                    if (response.isSuccessful) {
                        val status = response.body()?.status
                        val msg = response.body()?.message
                        if (status == 200) {
                            iTambahJadwalView.onSendDataSuccess(msg)
                        } else {
                            iTambahJadwalView.onSendDataFailed(msg)
                        }
                    } else {
                        iTambahJadwalView.onSendDataFailed(response.errorBody().toString())
                    }
                }
            })
    }
}