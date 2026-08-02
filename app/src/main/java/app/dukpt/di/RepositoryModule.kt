package app.dukpt.di

import app.dukpt.core.crypto.DukptSimulator
import app.dukpt.data.repository.CryptoRepositoryImpl
import app.dukpt.domain.repository.CryptoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCryptoRepository(
        impl: CryptoRepositoryImpl
    ): CryptoRepository
}

@Module
@InstallIn(SingletonComponent::class)
object CryptoModule {

    @Provides
    @Singleton
    fun provideDukptSimulator(): DukptSimulator {
        return DukptSimulator()
    }
}