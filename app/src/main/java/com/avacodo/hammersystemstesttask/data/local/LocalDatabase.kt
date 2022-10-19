package com.avacodo.hammersystemstesttask.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.avacodo.hammersystemstesttask.data.local.entity.BannersLocalEntity
import com.avacodo.hammersystemstesttask.data.local.entity.ProductsLocalEntity

private const val DB_NAME = "localDatabase"

@Database(
    entities = [ProductsLocalEntity::class, BannersLocalEntity::class],
    version = 1,
    exportSchema = true)
abstract class LocalDatabase : RoomDatabase() {
    abstract val cashDao: CashDao

    companion object {
        private var INSTANCE: LocalDatabase? = null

        fun getUserDatabase(context: Context): LocalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    LocalDatabase::class.java,
                    DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}