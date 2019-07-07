package xyz.lauwba.surelabs.lauwbaschedule.ui.tambah


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_tambah_jadwal.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast
import xyz.lauwba.surelabs.lauwbaschedule.R
import xyz.lauwba.surelabs.lauwbaschedule.controller.IAddSchedule
import xyz.lauwba.surelabs.lauwbaschedule.library.HourToMillis
import xyz.lauwba.surelabs.lauwbaschedule.library.MaskWatcher
import xyz.lauwba.surelabs.lauwbaschedule.model.MAddSchedule
import xyz.lauwba.surelabs.lauwbaschedule.model.data.tambah.TambahModel
import xyz.lauwba.surelabs.lauwbaschedule.view.IAddScheduleView

private const val USERNAME = "username"

class AddScheduleFragment : Fragment(), IAddScheduleView {

    private var username: String? = null

    private var add = TambahModel()
    private var mIAddSchedule: IAddSchedule? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            arguments?.let {
                username = it.getString(USERNAME)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tambah_jadwal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //instance interface and models
        mIAddSchedule = MAddSchedule(activity, this)

        sendSchedule.onClick {
            when {
                tanggalMulaiEdit.text?.isEmpty() == true -> tanggalMulaiEdit.error =
                    getString(R.string.required)
                jamMulai.text?.isEmpty() == true -> jamMulai.error = getString(R.string.required)
                tanggalSelesai.text?.isEmpty() == true -> tanggalSelesai.error =
                    getString(R.string.required)
                jamSelesai.text?.isEmpty() == true -> jamSelesai.error =
                    getString(R.string.required)
                keterangan.text?.isEmpty() == true -> keterangan.error =
                    getString(R.string.required)
                else -> {
                    add.username = username
                    add.kind = "Jadwal"
                    add.startDate = HourToMillis.dateHourToMillist(
                        context?.getString(
                            R.string.start_date,
                            tanggalMulaiEdit.text.toString(),
                            jamMulai.text.toString()
                        )
                    )
                    add.endDate = HourToMillis.dateHourToMillist(
                        context?.getString(
                            R.string.end_date,
                            tanggalSelesai.text.toString(),
                            jamSelesai.text.toString()
                        )
                    )
                    add.eventName = keterangan.text.toString()
                    mIAddSchedule?.sendSchedule(add)
                }
            }
        }

        setupUi()

    }

    private fun setupUi() {
        tanggalMulaiEdit.addTextChangedListener(MaskWatcher("##-##-####"))
        jamMulai.addTextChangedListener(MaskWatcher("##:##"))
        tanggalSelesai.addTextChangedListener(MaskWatcher("##-##-####"))
        jamSelesai.addTextChangedListener(MaskWatcher("##:##"))
    }

    override fun onSendDataSuccess(msg: String?) {
        toast(msg.toString())
    }

    override fun onSendDataFailed(msg: String?) {
        toast(msg.toString())
    }


    companion object {
        @JvmStatic
        fun newInstance(username: String) =
            AddScheduleFragment().apply {
                arguments = Bundle().apply {
                    putString(USERNAME, username)
                }
            }
    }

}
