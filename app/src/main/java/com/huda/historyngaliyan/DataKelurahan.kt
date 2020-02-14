package com.huda.historyngaliyan

import android.os.Parcel
import android.os.Parcelable

data class DataKelurahan(
    var photo: String?,
    var name: String?,
    var description: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(photo)
        parcel.writeString(name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataKelurahan> {
        override fun createFromParcel(parcel: Parcel): DataKelurahan {
            return DataKelurahan(parcel)
        }

        override fun newArray(size: Int): Array<DataKelurahan?> {
            return arrayOfNulls(size)
        }
    }
}