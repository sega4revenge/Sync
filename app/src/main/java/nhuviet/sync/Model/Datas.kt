package nhuviet.sync.Model

import io.realm.RealmObject

open class Datas : RealmObject() {
    var idm: String? = null
    var namem: String? = null
    var titlem: String? = null
    var img_lolm: String? = null

    override fun toString(): String {
        return "Datas(idm=$idm, namem=$namem, titlem=$titlem, img_lolm=$img_lolm)"
    }

}