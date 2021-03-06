package chat.rocket.android.authentication.presentation

import android.content.Context
import android.content.Intent
import chat.rocket.android.R
import chat.rocket.android.authentication.login.ui.LoginFragment
import chat.rocket.android.authentication.signup.ui.SignupFragment
import chat.rocket.android.authentication.twofactor.ui.TwoFAFragment
import chat.rocket.android.authentication.ui.AuthenticationActivity
import chat.rocket.android.main.ui.MainActivity
import chat.rocket.android.util.extensions.addFragmentBackStack
import chat.rocket.android.webview.webViewIntent

class AuthenticationNavigator(internal val activity: AuthenticationActivity, internal val context: Context) {
    fun toLogin() {
        activity.addFragmentBackStack("loginFragment", R.id.fragment_container) {
            LoginFragment.newInstance()
        }
    }

    fun toTwoFA(username: String, password: String) {
        activity.addFragmentBackStack("twoFAFragment", R.id.fragment_container) {
            TwoFAFragment.newInstance(username, password)
        }
    }

    fun toSignUp() {
        activity.addFragmentBackStack("signupFragment", R.id.fragment_container) {
            SignupFragment.newInstance()
        }
    }

    fun toWebPage(url: String) {
        activity.startActivity(context.webViewIntent(url))
        activity.overridePendingTransition(R.anim.slide_up, R.anim.hold)
    }

    fun toChatList() {
        val chatList = Intent(activity, MainActivity::class.java).apply {
            //TODO any parameter to pass
        }
        activity.startActivity(chatList)
        activity.finish()
    }

    fun toServerScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
