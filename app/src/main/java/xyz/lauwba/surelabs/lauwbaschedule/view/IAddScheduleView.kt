package xyz.lauwba.surelabs.lauwbaschedule.view

import xyz.lauwba.surelabs.lauwbaschedule.model.data.tambah.TambahModel

interface IAddScheduleView {
    fun onSendDataSuccess(msg : String?)
    fun onSendDataFailed(msg : String?)
}