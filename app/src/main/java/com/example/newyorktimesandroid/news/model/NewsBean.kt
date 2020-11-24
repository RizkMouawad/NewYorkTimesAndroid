package com.example.newyorktimesandroid.news.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewsBean(
    @SerializedName("abstract")
    val `abstract`: String,
    @SerializedName("adx_keywords")
    val adxKeywords: String,
    @SerializedName("asset_id")
    val assetId: Long,
    @SerializedName("byline")
    val byline: String,
    @SerializedName("column")
    val column: String?,
    @SerializedName("des_facet")
    val desFacet: List<String>,
    @SerializedName("eta_id")
    val etaId: Int,
    @SerializedName("geo_facet")
    val geoFacet: List<Any>,
    @SerializedName("id")
    val id: Long,
    @SerializedName("media")
    val media: List<Media>,
    @SerializedName("nytdsection")
    val nytdsection: String,
    @SerializedName("org_facet")
    val orgFacet: List<String>,
    @SerializedName("per_facet")
    val perFacet: List<String>,
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("section")
    val section: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("subsection")
    val subsection: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("updated")
    val updated: String,
    @SerializedName("uri")
    val uri: String,
    @SerializedName("url")
    val url: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!,
        source.readLong(),
        source.readString()!!,
        source.readString(),
        source.createStringArrayList()!!,
        source.readInt(),
        ArrayList<Any>().apply { source.readList(this, Any::class.java.classLoader) },
        source.readLong(),
        ArrayList<Media>().apply { source.readList(this, Media::class.java.classLoader) },
        source.readString()!!,
        source.createStringArrayList()!!,
        source.createStringArrayList()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(abstract)
        writeString(adxKeywords)
        writeLong(assetId)
        writeString(byline)
        writeString(column)
        writeStringList(desFacet)
        writeInt(etaId)
        writeList(geoFacet)
        writeLong(id)
        writeList(media)
        writeString(nytdsection)
        writeStringList(orgFacet)
        writeStringList(perFacet)
        writeString(publishedDate)
        writeString(section)
        writeString(source)
        writeString(subsection)
        writeString(title)
        writeString(type)
        writeString(updated)
        writeString(uri)
        writeString(url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<NewsBean> = object : Parcelable.Creator<NewsBean> {
            override fun createFromParcel(source: Parcel): NewsBean = NewsBean(source)
            override fun newArray(size: Int): Array<NewsBean?> = arrayOfNulls(size)
        }
    }
}