package com.levins.Matrix_Gilad_Levinson.repository

import android.content.Context
import android.util.Log
import com.levins.Matrix_Gilad_Levinson.model.jsonObject
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import model.PilesDataSource

class PileRepository( val applicationContext: Context) {

            public suspend fun selectAllPiles2(channelRepo:Channel<jsonObject?>) {//: List<Piles>? {// suspend
                    getlocations(channelRepo)
            }
            //happen when db is empty. usually when the application was just installed:
            private suspend fun getlocations(channelRepo: Channel<jsonObject?>) {
                //val channelFirestore = Channel<ArrayList<numberWithData>?>()
                val channelRetrofit = Channel<jsonObject?>()
                var locationsFromRetrofit: jsonObject? = null
                    val jobReceiver = CoroutineScope(currentCoroutineContext()).launch {

                        channelRetrofit.consumeEach { value ->
                            Log.v("channelVerific", "consumeEachViewModelVerific")
                            locationsFromRetrofit = value
                            /////////////////////
                            channelRepo.send(value)
                        }//consume loop
                    }
                    val jobSender = CoroutineScope(currentCoroutineContext()).launch {
                        val dataSource = PilesDataSource()
                        dataSource.getLocationsDynamically(channelRetrofit)
                    }
                }

        }



