package xyz.lauwba.surelabs.lauwbaschedule.adapter


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_overview_adapter.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import xyz.lauwba.surelabs.lauwbaschedule.R
import xyz.lauwba.surelabs.lauwbaschedule.library.HourToMillis
import xyz.lauwba.surelabs.lauwbaschedule.model.data.EventModel

class OverviewAdapter(
    private val context: Context?,
    private val models: List<EventModel?>?,
    private val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<OverviewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_overview_adapter, parent, false)
        return ViewHolder(v, onItemClickListener, context)
    }

    override fun getItemCount(): Int {
        return models!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(models?.get(position), position)
    }

    class ViewHolder(
        view: View,
        private val onItemClickListener: OnItemClickListener,
        private val context: Context?
    ) : RecyclerView.ViewHolder(view) {

        private val byColor = view.byColor
        private val tanggalEvent = view.tanggalEvent
        private val by = view.by
        private val eventName = view.EventName

        fun bindItem(
            models: EventModel?,
            position: Int
        ) {

            byColor.setBackgroundColor(Color.parseColor(models?.color))
            tanggalEvent.text =
                context?.resources?.getString(
                    R.string.event_date,
                    HourToMillis.millisToDateHour(models?.startDate?.toLong()),
                    HourToMillis.millisToDateHour(models?.startDate?.toLong())
                )
            by.text = models?.nama
            eventName.text = models?.eventName
            itemView.onClick {
                onItemClickListener.onItemClick(models, position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(models: EventModel?, position: Int)
    }

}
