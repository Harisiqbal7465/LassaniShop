package com.hidevelopers.lassanishop.data.local

import androidx.room.*
import com.hidevelopers.lassanishop.data.local.dto.*
import com.hidevelopers.lassanishop.data.local.dto.relationships.OwnRateListItemWithWeightPrice
import com.hidevelopers.lassanishop.data.local.dto.relationships.OwnRateListWithOwnRateListItemAndWeighPrice
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwnRateList(onwRateList: OwnRateListDto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompanyRateList(companyRateList: CompanyRateListDto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwnRateListItem(ownRateListItem: OwnRateLIstItemDto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompanyRateListItem(companyRateListItem: CompanyRateListItemDto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeightPrice(weightPrice: WeightPriceDto)

    @Transaction
    @Query("SELECT * FROM tblOwnRateList")
    fun getOwnRateList(): Flow<List<OwnRateListDto>>

    @Transaction
    @Query("SELECT COUNT(ownRateListId) FROM tblOwnRateListItem")
    fun getSizeOwnRateList(): Flow<Long>

    @Transaction
    @Query("SELECT * FROM tblCompanyRateList")
    fun getCompanyRateList(): Flow<List<CompanyRateListDto>>

    @Transaction
    @Query("SELECT COUNT(companyRateListId) FROM tblCompanyRateListItem")
    fun getSizeCompanyRateList(): Flow<Long>

    @Transaction
    @Query("SELECT * FROM tblOwnRateList WHERE ownRateListId = :ownRateListId")
    fun getOwnRateListWithRateListItemAndWeightPrice(ownRateListId: Int): Flow<List<OwnRateListWithOwnRateListItemAndWeighPrice>>

//    @Transaction
//    @Query("SELECT * FROM tblOwnRateList WHERE ownRateListId = :ownRateListId")
//    suspend fun getOwnRateListWithOwnRateListItem(ownRateListId: Int): List<OwnRateListWithOwnRateListItem>
//    @Transaction
//    @Query("SELECT * FROM tblOwnRateListItem WHERE ownRateListItemId = :ownRateListItemId")
//    suspend fun getOwnRateListWithWeightPrice(ownRateListItemId: Int): List<OwnRateListItemWithWeightPrice>
//    @Transaction
//    @Query("SELECT * FROM tblOwnRateListItem")
//    fun getOwnRateListWithWeightPrice(): Flow<List<OwnRateListItemWithWeightPrice>>
//
//    @Transaction
//    @Query("SELECT * FROM tblCompanyRateListItem")
//    fun getCompanyRateListItem(): Flow<List<CompanyRateListItemDto>>
}