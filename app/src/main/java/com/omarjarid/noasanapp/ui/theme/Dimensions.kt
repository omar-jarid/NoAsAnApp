package com.omarjarid.noasanapp.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Dimensions(val size16: Dp)

val defaultDimensions = Dimensions(size16 = 16.dp)

// Ratio is 4 for default and 3 for small.
val smallDimensions = Dimensions(size16 = 12.dp)