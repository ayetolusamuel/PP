package com.pedektech.pricepally.ui


import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedektech.pricepally.R
import com.pedektech.pricepally.adapters.EventAdapter
import com.pedektech.pricepally.adapters.MilongasAdapter
import com.pedektech.pricepally.adapters.TeachersAdapter
import com.pedektech.pricepally.databinding.ActivityMainBinding
import com.pedektech.pricepally.model.Data


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initRecyclerview(binding)
        setSupportActionBar(binding.appBarMain.toolbar)
        bottomNavImp()
        toolbarImpl()


    }

    /**

    Implements the toolbar by setting the support action bar to display the up button and

    the menu icon. The toolbar navigation click listener is set to open the drawer layout.
     */
    private fun toolbarImpl() {
        try {
            // Set support action bar to display up button and menu icon
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setHomeAsUpIndicator(R.drawable.ic_menu)
            }

            // Set toolbar navigation click listener to open drawer layout
            binding.appBarMain.toolbar.setNavigationOnClickListener {
                val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
                drawerLayout.openDrawer(GravityCompat.START)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    /**

    Sets up the bottom navigation bar by attaching an OnItemSelectedListener to it that displays a Toast message
    depending on the clicked item.
     */
    private fun bottomNavImp() {
        binding.navigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this@MainActivity, "Home is clicked.", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_search -> {
                    Toast.makeText(this@MainActivity, "Search is clicked.", Toast.LENGTH_SHORT)
                        .show()
                    true
                }
                R.id.nav_calendar -> {
                    Toast.makeText(this@MainActivity, "Calendar is clicked.", Toast.LENGTH_SHORT)
                        .show()
                    true
                }
                else -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Notification is clicked.",
                        Toast.LENGTH_SHORT
                    ).show()
                    false
                }
            }
        }
    }

    /**

    Initializes the RecyclerViews for Milongas, Teachers, and Events with their respective Adapters

    and LayoutManagers, using the provided binding object.

    @param binding The ActivityMainBinding object used to access the views.
     */
    private fun initRecyclerview(binding: ActivityMainBinding) {
        with(binding) {
            // Initializes the Milongas RecyclerView
            appBarMain.milongasRecyclerView.apply {
                adapter = MilongasAdapter(datas = listOf(Data(""), Data(""), Data(""), Data("")))
                layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            }

            // Initializes the Teachers RecyclerView
            appBarMain.teacherRecyclerView.apply {
                adapter = TeachersAdapter(datas = listOf(Data(""), Data(""), Data(""), Data("")))
                layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            }

            // Initializes the Events RecyclerView
            appBarMain.eventRecyclerView.apply {
                adapter = EventAdapter(datas = listOf(Data(""), Data(""), Data(""), Data("")))
                layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Handle the home button click event here
                Toast.makeText(this@MainActivity, "Home is clicked.", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}