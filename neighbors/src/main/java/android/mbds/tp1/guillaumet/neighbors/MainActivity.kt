package android.mbds.tp1.guillaumet.neighbors

import android.mbds.tp1.guillaumet.neighbors.di.DI
import android.mbds.tp1.guillaumet.neighbors.fragments.ListNeighborsFragment
import android.mbds.tp1.guillaumet.neighbors.fragments.MenuChoicePersistFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import androidx.fragment.app.Fragment
import android.widget.Toast




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        DI.inject(application)

        setContentView(R.layout.activity_main)
        changeFragment(ListNeighborsFragment())
    }

    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }





}