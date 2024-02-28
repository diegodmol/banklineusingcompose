package com.example.bankline.di

import com.example.bankline.data.repository.BankLineRepositoryImpl
import com.example.bankline.data.repository.BankLineRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun provideBankLineRepository(repository: BankLineRepositoryImpl): BankLineRepository
}