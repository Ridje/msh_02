package com.yrar.hackaton_02_yrar.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.core.content.contentValuesOf
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.yrar.hackaton_02_yrar.R
import com.yrar.hackaton_02_yrar.model.database.InterestEntity
import com.yrar.hackaton_02_yrar.model.database.RoleEntity
import com.yrar.hackaton_02_yrar.repository.*
import com.yrar.hackaton_02_yrar.retrofit.API
import com.yrar.hackaton_02_yrar.room.UserDatabase
import com.yrar.hackaton_02_yrar.utils.AppPreferences
import com.yrar.hackaton_02_yrar.utils.URLs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.net.URL
import javax.inject.Singleton

const val DB_NAME = "localbase.dt"

@Module
@InstallIn(SingletonComponent::class)
class Singleton {

    @Singleton
    @Provides
    fun provideJacksonBuilder() : Converter.Factory = JacksonConverterFactory.create()

    @Singleton
    @Provides
    fun provideOkHTTPClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDatabase(@ApplicationContext context: Context) : UserDatabase {


        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            DB_NAME)
            .createFromAsset("assetbase.dt")
            //дропает базу даннух перед каждой миграцией, используется только в девелопе
            .build()
    }


    @Singleton
    @Provides
    fun provideAPIService(converterFactory: Converter.Factory, okHttpClient: OkHttpClient): API {
        return Retrofit
            .Builder()
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .baseUrl(URLs.API_URL)
            .build()
            .create(API::class.java)
    }

    @Singleton
    @Provides
    fun provideRepositoryLocal(
        roomService: UserDatabase
    ): RepositoryLocal {
        return RepositoryLocalRoom(roomService)
    }

    @Singleton
    @Provides
    fun provideRepositoryNetwork(
        service: API
    ) : RepositoryNetwork {
        return RepositoryNetworkMock(service)
    }

    @Singleton
    @Provides
    fun providePreferences(@ApplicationContext context: Context): AppPreferences {
        return AppPreferences(context)
    }
}