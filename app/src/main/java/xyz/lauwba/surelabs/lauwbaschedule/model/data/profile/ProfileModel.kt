package xyz.lauwba.surelabs.lauwbaschedule.model.data.profile

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ProfileModel(

    var username: String? = null,

    @field:SerializedName("libur2")
    var libur2: String? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("color")
    val color: String? = null,

    @field:SerializedName("libur1")
    var libur1: String? = null,

    @field:SerializedName("last_loggedin")
    val lastLoggedin: String? = null
)