package xyz.lauwba.surelabs.lauwbaschedule.model.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class EventModelResponse(

    @field:SerializedName("data")
	val data: List<EventModel?>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("status")
	val status: Int? = null
)