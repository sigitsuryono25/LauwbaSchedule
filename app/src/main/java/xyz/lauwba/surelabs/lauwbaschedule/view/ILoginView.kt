package xyz.lauwba.surelabs.lauwbaschedule.view

import xyz.lauwba.surelabs.lauwbaschedule.model.data.login.LoginModel

interface ILoginView {
    fun onLoginSuccess(models: LoginModel?)
    fun onFailure(message : String?)
}