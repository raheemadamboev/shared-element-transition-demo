package xyz.teamgravity.sharedelementtransitiondemo

sealed interface Screen {
    val route: String

    data object List : Screen {
        override val route: String = "List"
    }

    data object Detail : Screen {
        override val route: String = "Detail"

        object Args {
            const val IMAGE = "image"
            const val TEXT = "text"
        }
    }
}