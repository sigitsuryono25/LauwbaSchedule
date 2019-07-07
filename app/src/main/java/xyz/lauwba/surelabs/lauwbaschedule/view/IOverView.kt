package xyz.lauwba.surelabs.lauwbaschedule.view

import xyz.lauwba.surelabs.lauwbaschedule.model.data.EventModel
import xyz.lauwba.surelabs.lauwbaschedule.model.data.EventModelResponse

interface IOverView {
    fun eventExist(models: List<EventModel?>?)
    fun eventNotExist(models: EventModelResponse?)
    fun onError(message : String?)
}