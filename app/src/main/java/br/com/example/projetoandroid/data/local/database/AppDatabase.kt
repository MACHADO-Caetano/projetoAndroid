package br.com.example.projetoandroid.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.example.projetoandroid.data.local.dao.PaymentDao

@Database(entities = [PaymentEntity::class, ], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun paymentDao(): PaymentDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "payment_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}