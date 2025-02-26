package com.coding.meet.screens.contact_me.components

inline fun <C : CharSequence, R : C> C.ifNotBlank(block: (C) -> R) = if (isNotBlank()) block(this) else ""