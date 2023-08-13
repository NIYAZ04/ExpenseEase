package com.example.expensetracker.models

sealed class Recurrence(val name:String, val target:String) {
    // lets go baby
    // As per SRS Document

    object None : Recurrence("None","None")
    object Daily : Recurrence("Daily","Day")
    object Weekly : Recurrence("Weekly","Week")
    object Monthly : Recurrence("Monthly","Month")
    object Yearly : Recurrence("Yearly","Year")



}//end