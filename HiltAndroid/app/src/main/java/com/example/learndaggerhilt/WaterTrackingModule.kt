package com.example.learndaggerhilt

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext


@InstallIn(FragmentComponent::class)
@Module
class WaterTrackingModule {

    @Provides
    fun providesPreferencesHelper(
        @ApplicationContext context:Context
    )=PreferencesHelper(context)
}