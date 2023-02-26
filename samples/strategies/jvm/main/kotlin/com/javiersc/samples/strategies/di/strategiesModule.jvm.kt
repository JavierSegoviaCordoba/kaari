package com.javiersc.samples.strategies.di

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.koin.dsl.module

val strategiesJvmModule = module { single { JdbcSqliteDriver.IN_MEMORY } }
