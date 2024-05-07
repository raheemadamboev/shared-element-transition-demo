package xyz.teamgravity.sharedelementtransitiondemo

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

object ItemProvider {
    val VALUE: ImmutableList<Int> = persistentListOf(
        R.drawable.i001,
        R.drawable.i002,
        R.drawable.i003
    )
}