package xyz.lauwba.surelabs.lauwbaschedule.model.data.profile

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ProfileModelResponse(

    @field:SerializedName("data")
	val data: ProfileModel? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("status")
	val status: Int? = null
)