package com.example.android.dagger.di

import com.example.android.dagger.registration.RegistrationActivity
import dagger.Component


/**
 * A @Component interface gives the information Dagger needs to generate the graph at compile-time. The parameter of the interface methods define what classes request injection.
 *
 */
// Definition of a Dagger component
@Component
interface AppComponent {
    // Classes that can be injected by this Component
    fun inject(activity: RegistrationActivity)
}