package xyz.lauwba.surelabs.lauwbaschedule.ui.profil


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*
import org.jetbrains.anko.backgroundColor
import xyz.lauwba.surelabs.lauwbaschedule.R
import xyz.lauwba.surelabs.lauwbaschedule.controller.IProfile
import xyz.lauwba.surelabs.lauwbaschedule.model.MProfile
import xyz.lauwba.surelabs.lauwbaschedule.model.data.profile.ProfileModel
import xyz.lauwba.surelabs.lauwbaschedule.view.IProfileView

private const val USERNAME = "username"

class ProfileFragment : Fragment(), IProfileView {

    private var usernames: String? = null
    private var iProfile: IProfile? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            usernames = it.getString(USERNAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iProfile = MProfile(activity, this)
        iProfile?.getProfileData(usernames)
//        iProfile?.onUpdateDataOff()
    }


    companion object {
        @JvmStatic
        fun newInstance(username: String?) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(USERNAME, username)
                }
            }
    }

    override fun onLoadDataSuccess(models: ProfileModel?) {
        nama.text = models?.nama
        username.text = usernames
        color.text = models?.color
        color.backgroundColor = Color.parseColor(models?.color)

        senin.setOnCheckedChangeListener { compoundButton, b ->

        }
    }

    override fun onLoadDataFailed(msg: String?) {

    }
}
