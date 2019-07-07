package xyz.lauwba.surelabs.lauwbaschedule.model.data.login

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class LoginModelResponse(

    @field:SerializedName("data")
	val data: LoginModel? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("status")
	val status: Int? = null
)