package com.example.networktest.model.presentation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*
Serializable vs Parcelable

Serializable its defined in java.lang.
Serializable is not customizable.
Serializable uses reflection to decompose/recreate the object.
Serializable a lot of temporal objects.

Parcelable its defined in Android framework.
Parcelable is customizable.
Parcelable does not use reflection.

Marshall and UnMarshall.

 */

@Parcelize
data class BookResponse(
    val items: List<BookItem>
): Parcelable

@Parcelize
data class BookItem(
    val volumeInfo: VolumeItem
): Parcelable

@Parcelize
data class VolumeItem(
    val title: String,
    val authors: List<String>,
    val imageLinks: ImageItem
): Parcelable

@Parcelize
data class ImageItem(
    val thumbnail: String
): Parcelable