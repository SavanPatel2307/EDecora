package com.example.edecora

import android.widget.TextView

class UserInfo {
    var id: String? = null
//    var fName: String? = null
//    var lName: String? = null
//    var emailTextView: String? = null
    var addL1: String? = null
//    var addL2: String? = null
    var cityTextView: String? = null
    var provinceTextView: String? = null
    var postalCodeTextView: String? = null
    var countryTextView: String? = null
    var uID: String? = null

    // empty constructor
    constructor() {}

    constructor(id: String, fName: String, lName: String, emailTextView: String, addL1: String, addL2: String, cityTextView: String, provinceTextView: String, postalCodeTextView: String, countryTextView: String) {
        this.id = id
//        this.fName = fName
//        this.lName = lName
//        this.emailTextView = emailTextView
        this.addL1 = addL1
//        this.addL2 = addL2
        this.cityTextView = cityTextView
        this.provinceTextView = provinceTextView
        this.postalCodeTextView = postalCodeTextView
        this.countryTextView = countryTextView
        this.uID = uID
    }
}