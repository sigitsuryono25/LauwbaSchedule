package xyz.lauwba.surelabs.lauwbaschedule.view

import xyz.lauwba.surelabs.lauwbaschedule.model.data.profile.ProfileModel

interface IProfileView {
    fun onLoadDataSuccess(models: ProfileModel?)
    fun onLoadDataFailed(msg: String?)
}