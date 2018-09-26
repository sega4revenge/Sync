//package com.example.nhuviet.greenfood.Presenter
//
//import android.os.Looper
//import android.util.Log
//import com.androidnetworking.error.ANError
//import com.example.nhuviet.greenfood.Model.InforLayout_Producst
//import com.example.nhuviet.greenfood.Model.Products
//import com.rx2androidnetworking.Rx2AndroidNetworking
//import io.reactivex.Observer
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.disposables.Disposable
//import io.reactivex.schedulers.Schedulers
//import org.json.JSONException
//import org.json.JSONObject
//
//
///**
// * Created by nhuvi on 12/11/2017.
// */
//class Presenter_Infor_Products_NongSan(view: IPresenter_Infor_ProductsNongsan) {
//    internal var inforProducstview = view
//    var productdetail = "USERDETAIL"
//    val BASE_URL = "http://192.168.1.27:8080/api/allnongsan"
//
//    //    fun get_Infor_Products(name_pro : String,price : String,imge_pro: String,number_product: Number,date_production: String,
////                           where_production: String,production_process: String,id_trademark: String,id_type_products: String)
//    fun get_Infor_ProductsNongSan(nongsan : String , thuyhaisan :String , thit : String) {
//
//        val jsonObject = JSONObject()
//        try {
////            jsonObject.put("_id", _id)
////            jsonObject.put("price", price)
////            jsonObject.put("imge_pro", imge_pro)
////            jsonObject.put("number_product", number_product)
////            jsonObject.put("date_production", date_production)
////            jsonObject.put("where_production", where_production)
////            jsonObject.put("production_process", production_process)
////            jsonObject.put("trademark", id_trademark)
////            jsonObject.put("type_products", id_type_products)
//
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//        // nong san
//        Rx2AndroidNetworking.post(BASE_URL)
//                .addJSONObjectBody(jsonObject)
//                .build()
//                .setAnalyticsListener { timeTakenInMillis, bytesSent, bytesReceived, isFromCache ->
//                    Log.d(productdetail, " timeTakenInMillis : " + timeTakenInMillis)
//                    Log.d(productdetail, " bytesSent : " + bytesSent)
//                    Log.d(productdetail, " bytesReceived : " + bytesReceived)
//                    Log.d(productdetail, " isFromCache : " + isFromCache)
//                }
//                .getObjectObservable(Products::class.java)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object : Observer<Products> {
//                    override fun onNext(products: Products?) {
//
//                        Log.d("productdetail", "onResponse isMainThread : " + (Looper.myLooper() == Looper.getMainLooper()).toString())
//                        inforProducstview.get_data_Infor_ProductsNongsan(products!!)
//                    }
//
//                    override fun onComplete() {
//                    }
//
//                    override fun onError(e: Throwable) {
//                        if (e is ANError) {
//
//                            Log.d(productdetail, "onError errorCode : " + e.errorCode)
//                            Log.d(productdetail, "onError errorBody : " + e.errorBody)
//                            Log.d(productdetail, e.errorDetail + " : " + e.message)
//                            inforProducstview.setErrorNotFound()
//
//                        } else {
//                            Log.d(productdetail, "onError errorMessage : " + e.message)
//                            inforProducstview.setErrorMessage("lỗi")
//                        }
//                    }
//
//                    override fun onSubscribe(d: Disposable) {
//
//                    }
//                })
//
//    }
//
//
//    interface IPresenter_Infor_ProductsNongsan {
//        fun setErrorNotFound()
//        fun setErrorMessage(errorMessage: String)
//        fun get_data_Infor_ProductsNongsan(infor_Pro_nongsan: Products?)
//
//    }
//}
//
//
//
