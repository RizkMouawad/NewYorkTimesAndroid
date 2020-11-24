package com.example.newyorktimesandroid.news.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MediaMetadata(
    @SerializedName("format")
    val format: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readInt(),
        source.readString()!!,
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(format)
        writeInt(height)
        writeString(url)
        writeInt(width)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MediaMetadata> =
            object : Parcelable.Creator<MediaMetadata> {
                override fun createFromParcel(source: Parcel): MediaMetadata = MediaMetadata(source)
                override fun newArray(size: Int): Array<MediaMetadata?> = arrayOfNulls(size)
            }
    }
}