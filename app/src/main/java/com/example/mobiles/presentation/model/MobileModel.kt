package com.example.mobiles.presentation.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MobileModel (
    val name: String,
    val image: Int,
    val brand: String,
    val price: Float
) : Parcelable