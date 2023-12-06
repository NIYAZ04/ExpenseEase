package com.example.expensetracker

import com.example.expensetracker.models.Category
import com.example.expensetracker.models.Expense
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.types.TypedRealmObject
import kotlin.reflect.KClass

val config = RealmConfiguration.create(schema = setOf(Expense::class, Category::class) as Set<KClass<out TypedRealmObject>>)
val db: Realm = Realm.open(config)