package xyz.lauwba.surelabs.lauwbaschedule.ui.home


import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.applandeo.materialcalendarview.CalendarUtils
import com.applandeo.materialcalendarview.EventDay
import kotlinx.android.synthetic.main.fragment_calendar.*
import xyz.lauwba.surelabs.lauwbaschedule.R
import java.util.*


class CalendarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val events = mutableListOf<EventDay>()
//
//        val calendar = Calendar.getInstance()
//        calendar.timeInMillis = 1562404640705
//        events.add(EventDay(calendar, CalendarUtils.getDrawableText(activity, "", Typeface.DEFAULT, android.R.color.holo_blue_dark, 14)))
//        calendarView.setEvents(events)
//
//        val calendar1 = Calendar.getInstance()
//        calendar1.timeInMillis = 1562691600000
//        events.add(EventDay(calendar1, CalendarUtils.getDrawableText(activity, "", Typeface.DEFAULT, android.R.color.holo_red_dark, 14)))
//        calendarView.setEvents(events)
    }
}
