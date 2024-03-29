package xyz.lauwba.surelabs.lauwbaschedule.library

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object HourToMillis {

    var locale = Locale("id", "ID")

    fun millis(): Long {
        val time = Calendar.getInstance(locale)
        return time.timeInMillis
    }

    fun addExpired(expiredOn: String?): Long {
        val sdf = SimpleDateFormat("dd-MMMM-yyyy HH:mm", locale)
        val now = sdf.format(Date())

        val date = sdf.parse(now)
        val c = Calendar.getInstance()
        Log.i("simple date format", date.toString())
        c.time = date
        c.add(Calendar.HOUR, expiredOn?.toInt() ?: 0)

        Log.i("Time", c.time.toString())

        return c.timeInMillis
    }

    fun millisToDate(milis: Long?): String {
        val sdf = SimpleDateFormat("dd-MMMM-yyyy", locale)
        val c = Calendar.getInstance()
        c.timeInMillis = milis!!
        return sdf.format(c.time)
    }

    fun millisToDateHour(milis: Long?): String {
        val sdf = SimpleDateFormat("dd-MMMM-yyyy HH:mm", locale)
        val c = Calendar.getInstance()
        c.timeInMillis = milis!!
        return sdf.format(c.time)
    }

    fun millisToHour(milis: Long): String {
        val sdf = SimpleDateFormat("HH:mm", locale)
        val c = Calendar.getInstance()
        c.timeInMillis = milis
        return sdf.format(c.time)
    }

    fun dateHourToMillist(date: String?): Long? {
        val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm", locale)
        var milist: Long? = null
        try {
            val mDate = sdf.parse(date)
            milist = mDate.time
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return milist
    }
}