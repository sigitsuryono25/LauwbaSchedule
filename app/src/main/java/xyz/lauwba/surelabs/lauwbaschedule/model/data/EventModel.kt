package xyz.lauwba.surelabs.lauwbaschedule.model.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class EventModel(

	@field:SerializedName("end_date")
	val endDate: String? = null,

	@field:SerializedName("id_schedule")
	val idSchedule: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("event_name")
	val eventName: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("start_date")
	val startDate: String? = null
)