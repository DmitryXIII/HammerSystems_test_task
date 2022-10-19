package com.avacodo.hammersystemstesttask.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avacodo.hammersystemstesttask.data.local.entity.BannersLocalEntity
import com.avacodo.hammersystemstesttask.data.local.entity.ProductsLocalEntity

@Dao
interface CashDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProductsToCash(dataList: List<ProductsLocalEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBannersToCash(dataList: List<BannersLocalEntity>)

    @Query("SELECT * FROM ProductsLocalEntity")
    suspend fun getProductsCash(): List<ProductsLocalEntity>

    @Query("SELECT * FROM BannersLocalEntity")
    suspend fun getBannersCash(): List<BannersLocalEntity>

    @Query("DELETE FROM ProductsLocalEntity")
    suspend fun clearProductsCash()

    @Query("DELETE FROM BannersLocalEntity")
    suspend fun clearBannersCash()
}