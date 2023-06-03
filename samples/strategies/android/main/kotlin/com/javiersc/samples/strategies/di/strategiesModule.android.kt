package com.javiersc.samples.strategies.di

import android.content.Context
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.koin.dsl.module

val strategiesAndroidModule = module {
    single<SqlDriver> {
        val schema: SqlSchema<QueryResult.Value<Unit>> = get()
        val context: Context = get()
        AndroidSqliteDriver(schema = schema, context = context)
    }
}
