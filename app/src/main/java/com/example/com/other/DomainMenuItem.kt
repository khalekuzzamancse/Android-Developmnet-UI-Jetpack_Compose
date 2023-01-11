package com.example.com.other

import android.provider.ContactsContract.CommonDataKinds.Identity
import androidx.annotation.DrawableRes

data class DomainMenuItem(
    val title:String,
    @DrawableRes val icon:Int
)
