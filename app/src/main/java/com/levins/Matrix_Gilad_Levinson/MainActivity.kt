package com.levins.Matrix_Gilad_Levinson

import android.content.Intent
import android.os.Build
import android.os.Bundle
//import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.levins.Matrix_Gilad_Levinson.ui.main.*
//import model.FirestoreSnapshotService
import androidx.annotation.RequiresApi
import com.levins.Matrix_Gilad_Levinson.view.ExtendedElementFragment

class MainActivity : AppCompatActivity() {
    private val LOGIN = 2


    //    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = intent.getStringExtra("category")
        val id = intent.getStringExtra("id")
        val imgUrl = intent.getStringExtra("imgUrl")
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
//                    HandlingTimeFragment.newInstance()
                    ExtendedElementFragment.newInstance(category,id,imgUrl)
//                    MainFragment.newInstance()
                )//MainFragment.newInstance())//AddPileFragment.newInstance())//AddPileFragment
                .commitNow()
        }

    }


    override fun onResume() {
        super.onResume()
        val intent = getIntent()
    }

    //happen after an image was chosen for the pile:
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(resultCode, requestCode, data)
        //after login finished of user pressed back:
        if (requestCode == LOGIN && resultCode == RESULT_OK) {
        }
    }

    //if a user is logged in , we will move to addPile fragment:

    //    if there is a logged in user:

    override fun onBackPressed() {
        val myFragment: Fragment? = supportFragmentManager.findFragmentByTag("AddPileFrag")
        if (myFragment != null && myFragment.isVisible) {
            moveToMainFrag()
            // add your code here
        } else super.onBackPressed()
        //todo if aner finished his activity add it here
    }

    fun moveToMainFrag() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment.newInstance())
            .commitNow()
    }


}