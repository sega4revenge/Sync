package nhuviet.sync.Presenter

import android.content.Context
import android.os.Looper
import android.util.Log
import com.androidnetworking.error.ANError
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import nhuviet.sync.Model.Person
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONArray
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.androidnetworking.interfaces.ParsedRequestListener
import io.realm.Realm
import io.realm.RealmList
import nhuviet.sync.Model.Datas


class Presenter_Sync(IP_View: IPresenter_Sync) {

    internal var mSync_view = IP_View
    var realm: Realm? = null
    var productdetail = "USERDETAIL"
    val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/8.17.1/data/en_US/champion.json"
    val BASE_URL1 = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/Taric_0.jpg"
    val marr_Person = RealmList<Person>()


    fun get_Infor_Sync() {
        val jsonObject = JSONObject()
        try {
//            jsonObject.put("type", "champion")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        AndroidNetworking.get(BASE_URL)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        val jsonObject_data = response!!.getJSONObject("data")
                        val keys = jsonObject_data.keys()
                        while (keys.hasNext()) {
                            val key = keys.next()
                            val mPerson = Person()
                            val id_per = response.getJSONObject("data").getJSONObject(key).getString("id")
//                            val name = response.getJSONObject("data").getJSONObject(key).getString("name")
//                            val title = response.getJSONObject("data").getJSONObject(key).getString("title")
//                            val img_lol = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${id_per}_0.jpg"
                            mPerson.id = id_per
                            mPerson.name = response.getJSONObject("data").getJSONObject(key).getString("name")
                            mPerson.title = response.getJSONObject("data").getJSONObject(key).getString("title")
                            mPerson.img_lol = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${id_per}_0.jpg"
//                            save_to_data(id_per, title, name, img_lol)
                            marr_Person.add(mPerson)
                            mSync_view.ViewJson_Sync(marr_Person)
                        }
                    }

                    override fun onError(anError: ANError) {
                        // handle error
                        mSync_view.setErrorMessage(anError.toString())
                    }

                })
    }

    //    ========================Save Pro Cart
    fun save_to_data(id: String, title: String, name: String, img_lol: String) {
        realm = Realm.getDefaultInstance() // opens "myrealm.realm"
        realm?.executeTransactionAsync({ bgRealm ->
            var mPersonSync = bgRealm.where(Datas::class.java).equalTo("idm", id).findFirst()
            if (mPersonSync == null) {
                mPersonSync = bgRealm.createObject(Datas::class.java)
            }

            mPersonSync?.idm = id
            mPersonSync?.titlem = title
            mPersonSync?.namem= name
            mPersonSync?.img_lolm = img_lol

        }, {
            Log.v("Succsess", "------------------->Ok<-----------------")
        }, {
            Log.e("Pailed", "---------------->Err<----------------")
        })
    }

    interface IPresenter_Sync {
        fun ViewJson_Sync(arrList_LoL: RealmList<Person>)
        fun setErrorNotFound()
        fun setErrorMessage(errorMessage: String)
    }
}