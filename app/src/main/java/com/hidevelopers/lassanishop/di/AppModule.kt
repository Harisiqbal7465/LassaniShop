package com.hidevelopers.lassanishop.di

import android.content.Context
import com.hidevelopers.lassanishop.data.local.ShopDao
import com.hidevelopers.lassanishop.data.local.ShopDataBase
import com.hidevelopers.lassanishop.data.reposiitory.RateListRepositoryImpl
import com.hidevelopers.lassanishop.domain.repository.RateListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext context: Context) = context

    @Singleton
    @Provides
    fun provideShopDao(@ApplicationContext context: Context) : ShopDao {
        return ShopDataBase.getInstance(context).shopDao
    }

    @Singleton
    @Provides
    fun provideListRepository(
        shopDao: ShopDao
    ): RateListRepository{
        return RateListRepositoryImpl(shopDao)
    }
}