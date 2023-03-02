package com.alex.movila.di

import com.alex.movila.data.network.datasource.MovieDataSourceRemote
import com.alex.movila.data.network.datasource.MovieDataSourceRemoteImpl
import com.alex.movila.data.repository.MovieRepository
import com.alex.movila.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class MovieModule {
    @Binds
    abstract fun bindMovieRepository(impl: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun binMovieDataSourceRemote(impl: MovieDataSourceRemoteImpl): MovieDataSourceRemote
}