package com.example.mdp_cvbuilderapp

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.mdp_cvbuilderapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var sharedPref: SharedPreferences = SharedPreferenceUtils.getSharedPref()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = SharedPreferenceUtils.getPref(getString(R.string.username))

        /*An Adapter object acts as a bridge between an AdapterView and the data for that view*/

        val pa = PageAdapter(this)
        viewpager.adapter =pa // in this line the viewpager has 4 fragemnt then the next is
        //depending on the tab i am going to click change the fragment.
        //i have 4 viewpage id
        //the TabLayoutMediator use viewpage id and tabelayout id to display the fragment in
        //the viewpager2


        // align the space  to the Screen size
        tablelayout.tabGravity = TabLayout.GRAVITY_FILL
        /* Setting up Tab Layout with the ViewPageg2 is handled by the TabLayoutMediator*/

        TabLayoutMediator(tablelayout, viewpager){tab, position ->
            when(position){
                0->{
                    tab.text = "Home"
                }
                1->{
                    tab.text = "Work"
                }
                2->{
                    tab.text = "CONTACT"
                }
                3->{
                    tab.text = "About Me"
                }
            }
        }.attach()

        user?.apply { toolbar.title = "$user CV" }

        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {

                R.id.email -> {
                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:")
                    intent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.email_account))
                    intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
                    intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_body))
                    startActivity(intent)
                    return@setOnMenuItemClickListener true
                }
                R.id.dail -> {
                    val intent = Intent()
                    intent.action = Intent.ACTION_DIAL
                    val et2 = resources.getString(R.string.mynumber)
                    intent.data = Uri.parse("tel:$et2")
                    startActivity(intent)
                    return@setOnMenuItemClickListener true
                }
                R.id.whatsup -> {
                    val intent = packageManager.getLaunchIntentForPackage("com.whatsapp")
                    if(intent!=null)
                        startActivity(intent)
                    else
                        Toast.makeText(applicationContext,"WhatsApp not installed", Toast.LENGTH_LONG).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.linkedin -> {
                    val uri = Uri.parse(resources.getString(R.string.my_linkedin_account));
                    val it = Intent(Intent.ACTION_VIEW,uri);
                    startActivity(it);
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_main_logout->{
                    finish()
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_main_logout -> {
                    finish()
                    return@setOnMenuItemClickListener true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }


}