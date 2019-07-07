package xyz.lauwba.surelabs.lauwbaschedule.network

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import xyz.lauwba.surelabs.lauwbaschedule.model.data.EventModelResponse
import xyz.lauwba.surelabs.lauwbaschedule.model.data.login.LoginModelResponse
import xyz.lauwba.surelabs.lauwbaschedule.model.data.profile.ProfileModelResponse
import xyz.lauwba.surelabs.lauwbaschedule.model.data.tambah.CUDResponse

interface ApiService {
    @GET("go_get_evenlist")
    fun goGetListData(): Call<EventModelResponse>

    @FormUrlEncoded
    @POST("go_login")
    fun goLogin(@Field("username") username: String?, @Field("pswd") pswd: String?): Call<LoginModelResponse>

    @FormUrlEncoded
    @POST("go_put_event")
    fun goPutEvent(
        @Field("username") username: String?,
        @Field("start_date") startDate: Long?,
        @Field("end_date") endDate: Long?,
        @Field("event_name") eventName: String?,
        @Field("kind") kind: String?
    ): Call<CUDResponse>

    @FormUrlEncoded
    @POST("go_update_libur")
    fun goUpdateLibur(
        @Field("username") username: String?,
        @Field("libur1") libur1: String?,
        @Field("libur2") libur2: String?
    ): Call<CUDResponse>

    @FormUrlEncoded
    @POST("go_get_profile")
    fun goGetProfile(
        @Field("username") username: String?
    ): Call<ProfileModelResponse>
}