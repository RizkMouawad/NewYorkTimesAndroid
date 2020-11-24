package com.example.newyorktimesandroid.news.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("approved_for_syndication")
    val approvedForSyndication: Int,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetadata>,
    @SerializedName("subtype")
    val subtype: String,
    @SerializedName("type")
    val type: String
) : Parcelable{
    constructor(source: Parcel) : this(
    source.readInt(),
    source.readString()!!,
    source.readString()!!,
    ArrayList<MediaMetadata>().apply {
        source.readList(
            this,
            MediaMetadata::class.java.classLoader
        )
    },
    source.readString()!!,
    source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(approvedForSyndication)
        writeString(caption)
        writeString(copyright)
        writeList(mediaMetadata)
        writeString(subtype)
        writeString(type)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Media> = object : Parcelable.Creator<Media> {
            override fun createFromParcel(source: Parcel): Media = Media(source)
            override fun newArray(size: Int): Array<Media?> = arrayOfNulls(size)
        }
    }
}