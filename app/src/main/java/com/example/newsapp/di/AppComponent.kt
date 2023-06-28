package com.example.shopingapp.di

import android.app.Application
import com.example.shopingapp.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Interface to bind all module components with Application
 * */
@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (NetworkModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

//        @BindsInstance
//        fun roomDatabase(application: RoomDatabaseModule): Builder

        fun build(): AppComponent
    }

    fun inject(instance: MyApplication)

}