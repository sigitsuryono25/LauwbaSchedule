package xyz.lauwba.surelabs.lauwbaschedule.controller

import xyz.lauwba.surelabs.lauwbaschedule.model.data.profile.ProfileModel

interface IProfile {
    fun onUpdateDataOff(models : ProfileModel?)
    fun getProfileData(username: String?)
}