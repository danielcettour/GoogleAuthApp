package com.example.googleauthapp.navigation

/**
 * sealed class that contains both screens
 */
sealed class Screen(val route: String) {
    object Login: Screen(route="login_screen") // accessed then with 'Screen.Login.route'
    object Profile: Screen(route="profile_screen")
}
