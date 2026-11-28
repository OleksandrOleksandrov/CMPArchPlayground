package com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview

import androidx.compose.ui.tooling.preview.Preview

/**
 * Annotation for creating a default preview.
 */
@Preview
annotation class AppPreview

/**
 * An annotation for previewing Composables
 * on different screen sizes (4 inch, 5.5 inch, 10 inch),
 * and with text scaling (1.5x, 2x).
 */
@AppPreview4Inch
@AppPreview5Dot5Inch
@AppPreview5Dot5InchHorizontal
@AppPreview10Inch
@AppPreviewScaledText1Dot5
@AppPreviewScaledText2x
annotation class AppPreviewAll

/**
 * An annotation for previewing Composables on a 4 inch phone screen.
 */
@Preview(
    name = "4 inch",
    group = "Devices",
    widthDp = 320,
    heightDp = 480,
    showBackground = true,
)
annotation class AppPreview4Inch

/**
 * An annotation for previewing Composables on a 5.5 inch phone screen.
 */
@Preview(
    name = "5.5 inch",
    group = "Devices",
    widthDp = 360,
    heightDp = 640,
    showBackground = true,
)
annotation class AppPreview5Dot5Inch

/**
 * An annotation for previewing Composables on a 5.5 inch on horizontal phone screen.
 */
@Preview(
    name = "5.5 inch horizontal",
    group = "Devices",
    heightDp = 360,
    widthDp = 640,
    showBackground = true,
)
annotation class AppPreview5Dot5InchHorizontal

/**
 * An annotation for previewing Composables on a 10 inch tablet screen.
 */
@Preview(
    name = "10 inch",
    group = "Devices",
    widthDp = 799,
    heightDp = 1279,
    showBackground = true,
)
annotation class AppPreview10Inch

/**
 * An annotation for previewing Composables with a text scaling factor of 1.5x.
 */
@Preview(
    name = "Scaled Text 1.5x",
    group = "Scaling",
    fontScale = 1.5f,
    showBackground = true,
)
annotation class AppPreviewScaledText1Dot5

/**
 * An annotation for previewing Composables with a text scaling factor of 2x.
 */
@Preview(
    name = "Scaled Text 2x",
    group = "Scaling",
    fontScale = 2f,
    showBackground = true,
)
annotation class AppPreviewScaledText2x
