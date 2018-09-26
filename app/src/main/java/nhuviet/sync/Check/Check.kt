package nhuviet.sync.Check

import android.app.Service
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class Check(var mcontext: Context) {

    fun isConnected(): Boolean {
        val mconnect_activity = mcontext.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        val infor = mconnect_activity.activeNetworkInfo
        if (infor != null) {
            if (infor.state == NetworkInfo.State.CONNECTED) {
            }
            return true
        }
        return false
    }
}