package xyz.lauwba.surelabs.lauwbaschedule.controller

import xyz.lauwba.surelabs.lauwbaschedule.model.data.tambah.TambahModel

interface IAddSchedule {

    fun sendSchedule(models : TambahModel)
}