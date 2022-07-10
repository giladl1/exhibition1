package com.levins.Matrix_Gilad_Levinson

import android.app.Application
import com.levins.Matrix_Gilad_Levinson.repository.PileRepository
//import com.levins.Matrix_Gilad_Levinson.room.PileDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class Matrix_Gilad_LevinsonApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts

//    val database by lazy { PileDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { PileRepository(/*database.daoAccess()!!,*/applicationContext) }
//    val db by lazy {FirebaseFirestore.getInstance()}
}

