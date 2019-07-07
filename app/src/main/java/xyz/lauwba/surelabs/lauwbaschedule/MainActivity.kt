package xyz.lauwba.surelabs.lauwbaschedule

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import xyz.lauwba.surelabs.lauwbaschedule.library.SecurePreferences
import xyz.lauwba.surelabs.lauwbaschedule.ui.home.CalendarFragment
import xyz.lauwba.surelabs.lauwbaschedule.ui.home.DashboardFragment
import xyz.lauwba.surelabs.lauwbaschedule.ui.profil.ProfileFragment
import xyz.lauwba.surelabs.lauwbaschedule.ui.tambah.AddScheduleFragment

class MainActivity : AppCompatActivity() {
    private var s: SecurePreferences? = null
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    title = "Overview Schedule"
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.container,
                            DashboardFragment()
                        )
                        .commitNow()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    title = "Tambah Jadwal"
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.container,
                            AddScheduleFragment.newInstance(s?.getString("username").toString())
                        ).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    title = "Ringkasan Profil"
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.container,
                            ProfileFragment.newInstance(s?.getString("username").toString())
                        ).commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        //setFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DashboardFragment())
            .commit()

        //set title
        title = "Overview Schedule"

        //set securepref
        s = SecurePreferences(this, "asiyaaaaaapppppp", true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.view_settings, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.calendar -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CalendarFragment())
                    .commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
