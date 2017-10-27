package codemakers.daggermvvm.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by Asus on 17/10/2017.
 */
@SuppressLint("ParcelCreator")
@Entity
@Parcelize
class Todo(@PrimaryKey var id: Long?,
           var title: String?,
           var description: String?,
           var date: Date) : Parcelable {

    @Ignore
    constructor(title: String, description: String?) : this(null, title, description, Date())

    companion object : Parceler <Todo> {
        override fun create(parcel: Parcel): Todo
                = Todo(parcel.readLong(),
                parcel.readString(),
                parcel.readString(),
                parcel.readSerializable() as Date)

        override fun Todo.write(parcel: Parcel, flags: Int) {
            parcel.writeLong(id!!)
            parcel.writeString(title)
            parcel.writeString(description)
            parcel.writeSerializable(date)
        }


    }

}