package xyz.lauwba.surelabs.lauwbaschedule.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.jetbrains.anko.support.v4.toast
import xyz.lauwba.surelabs.lauwbaschedule.R
import xyz.lauwba.surelabs.lauwbaschedule.adapter.OverviewAdapter
import xyz.lauwba.surelabs.lauwbaschedule.controller.IOverViewSchedule
import xyz.lauwba.surelabs.lauwbaschedule.model.MEvent
import xyz.lauwba.surelabs.lauwbaschedule.model.data.EventModel
import xyz.lauwba.surelabs.lauwbaschedule.model.data.EventModelResponse
import xyz.lauwba.surelabs.lauwbaschedule.view.IOverView

class DashboardFragment : Fragment(), IOverView {
    override fun onError(message: String?) {
        toast(message.toString())
    }

    private var mIOverViewSchedule: IOverViewSchedule? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mIOverViewSchedule = MEvent(context, this)
        mIOverViewSchedule?.getListEvent()
    }

    override fun eventExist(models: List<EventModel?>?) {
        val adapter =
            OverviewAdapter(context, models, object : OverviewAdapter.OnItemClickListener {
                override fun onItemClick(models: EventModel?, position: Int) {
                    toast(models?.username.toString())
                }

            })

        overViewEvent.layoutManager = LinearLayoutManager(context)
        overViewEvent.adapter = adapter
    }

    override fun eventNotExist(models: EventModelResponse?) {
        toast(models?.message.toString())
    }
}
