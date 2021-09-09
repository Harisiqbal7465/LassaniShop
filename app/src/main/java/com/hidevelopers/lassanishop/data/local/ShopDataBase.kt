package com.hidevelopers.lassanishop.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hidevelopers.lassanishop.data.local.dto.*

@Database(
    entities = [
        OwnRateListDto::class,
        OwnRateLIstItemDto::class,
        WeightPriceDto::class,
        CompanyRateListDto::class,
        CompanyRateListItemDto::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ShopDataBase : RoomDatabase() {
    abstract val shopDao: ShopDao

    companion object {
        @Volatile
        private var INSTANCE: ShopDataBase? = null

        fun getInstance(context: Context): ShopDataBase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ShopDataBase::class.java,
                    "shop_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}