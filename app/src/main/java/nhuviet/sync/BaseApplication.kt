package nhuviet.sync

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by nhuvi on 1/5/2018.
 */
class BaseApplication : Application()  {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("myrealm.realm").build()
        Realm.setDefaultConfiguration(config)
    }

}
