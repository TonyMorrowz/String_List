package com.example.stringlist

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "string_table")
data class StringItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val string: String
): Parcelable