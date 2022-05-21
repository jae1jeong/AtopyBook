package com.james.atopybook.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

abstract class DailyRecordDatabase:RoomDatabase() {

    abstract val dao:DailyRecordDao

    companion object{
        fun getInstance(context: Context):DailyRecordDatabase = Room.databaseBuilder(context,DailyRecordDatabase::class.java,"daily_record_db")
            .addCallback(object:Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Executors.newSingleThreadExecutor().execute {
                        runBlocking {
                            getInstance(context).dao
                        }
                    }
                }
            }).build()

    }
}