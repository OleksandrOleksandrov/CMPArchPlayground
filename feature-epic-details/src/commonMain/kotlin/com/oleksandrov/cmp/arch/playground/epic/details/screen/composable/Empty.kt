package com.oleksandrov.cmp.arch.playground.epic.details.screen.composable

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object Empty

val Empty.Empty: ImageVector?
    get() {
        _Empty?.let {
            return it
        }
        _Empty = ImageVector.Builder(
            name = "Empty",
            defaultWidth = 400.dp,
            defaultHeight = 400.dp,
            viewportWidth = 400f,
            viewportHeight = 400f
        ).apply {
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF2A2D34),
                        1f to Color(0xFF121316)
                    ),
                    center = Offset(200f, 200f),
                    radius = 180f
                )
            ) {
                moveTo(200f, 200f)
                moveToRelative(-180f, 0f)
                arcToRelative(180f, 180f, 0f, isMoreThanHalf = true, isPositiveArc = true, 360f, 0f)
                arcToRelative(180f, 180f, 0f, isMoreThanHalf = true, isPositiveArc = true, -360f, 0f)
            }
            path(
                fillAlpha = 0.6f,
                stroke = SolidColor(Color(0xFF3A3F4D)),
                strokeAlpha = 0.6f,
                strokeLineWidth = 2f
            ) {
                moveTo(200f, 200f)
                moveToRelative(-140f, 0f)
                arcToRelative(140f, 140f, 0f, isMoreThanHalf = true, isPositiveArc = true, 280f, 0f)
                arcToRelative(140f, 140f, 0f, isMoreThanHalf = true, isPositiveArc = true, -280f, 0f)
            }
            path(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color(0xFF2E3340)),
                strokeAlpha = 0.4f,
                strokeLineWidth = 1.5f
            ) {
                moveTo(200f, 200f)
                moveToRelative(-110f, 0f)
                arcToRelative(110f, 110f, 0f, isMoreThanHalf = true, isPositiveArc = true, 220f, 0f)
                arcToRelative(110f, 110f, 0f, isMoreThanHalf = true, isPositiveArc = true, -220f, 0f)
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f
            ) {
                moveTo(110f, 120f)
                quadTo(110f, 125f, 105f, 125f)
                quadTo(110f, 125f, 110f, 130f)
                quadTo(110f, 125f, 115f, 125f)
                quadTo(110f, 125f, 110f, 120f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.7f,
                strokeAlpha = 0.7f
            ) {
                moveTo(290f, 110f)
                quadTo(290f, 115f, 285f, 115f)
                quadTo(290f, 115f, 290f, 120f)
                quadTo(290f, 115f, 295f, 115f)
                quadTo(290f, 115f, 290f, 110f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f
            ) {
                moveTo(310f, 260f)
                quadTo(310f, 265f, 305f, 265f)
                quadTo(310f, 265f, 310f, 270f)
                quadTo(310f, 265f, 315f, 265f)
                quadTo(310f, 265f, 310f, 260f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f
            ) {
                moveTo(90f, 270f)
                quadTo(90f, 273f, 87f, 273f)
                quadTo(90f, 273f, 90f, 276f)
                quadTo(90f, 273f, 93f, 273f)
                quadTo(90f, 273f, 90f, 270f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f
            ) {
                moveTo(130f, 230f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f
            ) {
                moveTo(260f, 180f)
                moveToRelative(-2f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 4f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -4f, 0f)
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f
            ) {
                moveTo(160f, 100f)
                moveToRelative(-1f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2f, 0f)
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f
            ) {
                moveTo(240f, 290f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
            path(
                fill = SolidColor(Color(0xFF4A4E57)),
                fillAlpha = 0.35f,
                strokeAlpha = 0.35f
            ) {
                moveTo(280f, 140f)
                moveToRelative(-16f, 0f)
                arcToRelative(16f, 16f, 0f, isMoreThanHalf = true, isPositiveArc = true, 32f, 0f)
                arcToRelative(16f, 16f, 0f, isMoreThanHalf = true, isPositiveArc = true, -32f, 0f)
            }
            path(
                fillAlpha = 0.35f,
                stroke = SolidColor(Color(0xFF6A707C)),
                strokeAlpha = 0.35f,
                strokeLineWidth = 1.5f
            ) {
                moveTo(260.68f, 145.18f)
                arcTo(8f, 22f, 75f, isMoreThanHalf = false, isPositiveArc = false, 299.32f, 134.82f)
                arcTo(8f, 22f, 75f, isMoreThanHalf = false, isPositiveArc = false, 260.68f, 145.18f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF4A4E57)),
                fillAlpha = 0.85f,
                strokeAlpha = 0.85f
            ) {
                moveTo(161.05f, 248.04f)
                quadTo(149.29f, 308.76f, 142.95f, 322.35f)
                quadTo(149.29f, 308.76f, 188.24f, 260.72f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF7A808C)),
                fillAlpha = 0.85f,
                strokeAlpha = 0.85f
            ) {
                moveTo(165.58f, 250.15f)
                quadTo(157.74f, 290.63f, 151.4f, 304.23f)
                quadTo(157.74f, 290.63f, 183.71f, 258.6f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD0D4DC)),
                fillAlpha = 0.85f,
                strokeAlpha = 0.85f
            ) {
                moveTo(169.21f, 251.84f)
                quadTo(164.08f, 277.04f, 159.85f, 286.1f)
                quadTo(164.08f, 277.04f, 180.08f, 256.91f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF6A707C),
                        0.5f to Color(0xFF4A4E57),
                        1f to Color(0xFF32353B)
                    ),
                    start = Offset(131.49f, 198.5f),
                    end = Offset(173.12f, 198.5f)
                )
            ) {
                moveTo(173.12f, 198.5f)
                lineTo(133.55f, 224.18f)
                curveTo(128.36f, 230.59f, 133.86f, 235.36f, 140.2f, 238.32f)
                lineTo(162.86f, 232.33f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF6A707C),
                        0.5f to Color(0xFF4A4E57),
                        1f to Color(0xFF32353B)
                    ),
                    start = Offset(199.11f, 219.63f),
                    end = Offset(224.18f, 219.63f)
                )
            ) {
                moveTo(218.43f, 219.63f)
                lineTo(224.18f, 266.45f)
                curveTo(222.62f, 274.54f, 215.43f, 273.4f, 209.08f, 270.44f)
                lineTo(199.11f, 249.24f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF2B2D33)),
                fillAlpha = 0.5f,
                strokeAlpha = 0.5f
            ) {
                moveTo(187.92f, 216.44f)
                lineTo(170.17f, 254.5f)
                curveTo(168.9f, 257.22f, 171.68f, 260.72f, 171.68f, 260.72f)
                curveTo(171.68f, 260.72f, 176.16f, 260.6f, 177.42f, 257.88f)
                lineTo(195.17f, 219.82f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF6A707C),
                        0.5f to Color(0xFF4A4E57),
                        1f to Color(0xFF32353B)
                    ),
                    start = Offset(171.7f, 212.33f),
                    end = Offset(196.38f, 212.33f)
                )
            ) {
                moveTo(190.94f, 212.33f)
                lineTo(171.92f, 253.11f)
                curveTo(171.08f, 254.92f, 172.95f, 258f, 172.95f, 258f)
                curveTo(172.95f, 258f, 176.52f, 257.46f, 177.36f, 255.65f)
                lineTo(196.38f, 214.86f)
                close()
            }
            path(fill = SolidColor(Color(0xFF32353B))) {
                moveTo(163.52f, 240.37f)
                lineTo(192.52f, 253.89f)
                lineTo(184.67f, 261.26f)
                lineTo(162.92f, 251.12f)
                close()
            }
            path(fill = SolidColor(Color(0xFF232529))) {
                moveTo(163.52f, 240.37f)
                arcToRelative(3f, 16f, 115f, isMoreThanHalf = true, isPositiveArc = false, 29f, 13.52f)
                arcToRelative(3f, 16f, 115f, isMoreThanHalf = true, isPositiveArc = false, -29f, -13.52f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFD0D4DC),
                        0.4f to Color(0xFFE8EAEF),
                        0.7f to Color(0xFFB8BEC9),
                        1f to Color(0xFF888E99)
                    ),
                    start = Offset(155.37f, 86.71f),
                    end = Offset(258.18f, 86.71f)
                )
            ) {
                moveTo(189.72f, 151.07f)
                curveTo(215.07f, 96.69f, 252.83f, 86.71f, 252.83f, 86.71f)
                curveTo(252.83f, 86.71f, 269.45f, 122.05f, 244.09f, 176.43f)
                lineTo(200.68f, 257.69f)
                lineTo(155.37f, 236.56f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xCC5A606B),
                        1f to Color(0xE53A3E47)
                    ),
                    start = Offset(178.02f, 86.71f),
                    end = Offset(258.18f, 86.71f)
                )
            ) {
                moveTo(252.83f, 86.71f)
                curveTo(252.83f, 86.71f, 269.45f, 122.05f, 244.09f, 176.43f)
                lineTo(200.68f, 257.69f)
                lineTo(178.02f, 247.13f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF6A707C),
                        0.5f to Color(0xFF4A4E57),
                        1f to Color(0xFF32353B)
                    ),
                    start = Offset(220.52f, 86.71f),
                    end = Offset(253.57f, 86.71f)
                )
            ) {
                moveTo(220.52f, 115.78f)
                curveTo(233.5f, 99.77f, 252.83f, 86.71f, 252.83f, 86.71f)
                curveTo(252.83f, 86.71f, 255.25f, 109.91f, 251.33f, 130.15f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF9AA0A8),
                        1f to Color(0xFF4A4E57)
                    ),
                    start = Offset(197.89f, 137.95f),
                    end = Offset(240.15f, 180.5f)
                )
            ) {
                moveTo(219.02f, 159.22f)
                moveToRelative(-19.03f, -8.87f)
                arcToRelative(21f, 21f, 85.55f, isMoreThanHalf = true, isPositiveArc = true, 38.06f, 17.75f)
                arcToRelative(21f, 21f, 85.55f, isMoreThanHalf = true, isPositiveArc = true, -38.06f, -17.75f)
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF2B303A),
                        1f to Color(0xFF181A1F)
                    ),
                    start = Offset(202.92f, 143.01f),
                    end = Offset(235.12f, 175.43f)
                )
            ) {
                moveTo(219.02f, 159.22f)
                moveToRelative(-14.5f, -6.76f)
                arcToRelative(16f, 16f, 76.95f, isMoreThanHalf = true, isPositiveArc = true, 29f, 13.52f)
                arcToRelative(16f, 16f, 76.95f, isMoreThanHalf = true, isPositiveArc = true, -29f, -13.52f)
            }
            path(
                fill = SolidColor(Color.White),
                fillAlpha = 0.3f,
                strokeAlpha = 0.3f
            ) {
                moveTo(211.1f, 147.8f)
                arcTo(13f, 13f, 74.96f, isMoreThanHalf = false, isPositiveArc = true, 231.04f, 157.1f)
                arcTo(16f, 16f, 101.6f, isMoreThanHalf = false, isPositiveArc = false, 211.1f, 147.8f)
                close()
            }
            path(
                fill = SolidColor(Color.White),
                fillAlpha = 0.2f,
                strokeAlpha = 0.2f
            ) {
                moveTo(224.64f, 168.46f)
                moveToRelative(-1.81f, -0.85f)
                arcToRelative(2f, 2f, 114.23f, isMoreThanHalf = true, isPositiveArc = true, 3.63f, 1.69f)
                arcToRelative(2f, 2f, 114.23f, isMoreThanHalf = true, isPositiveArc = true, -3.63f, -1.69f)
            }
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.6f,
                stroke = SolidColor(Color(0xFF5A606B)),
                strokeAlpha = 0.6f,
                strokeLineWidth = 1.5f
            ) {
                moveTo(174.62f, 188.17f)
                lineTo(225.38f, 211.83f)
            }
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 0.6f,
                stroke = SolidColor(Color(0xFF5A606B)),
                strokeAlpha = 0.6f,
                strokeLineWidth = 1.5f
            ) {
                moveTo(165.87f, 211.67f)
                lineTo(213f, 233.65f)
            }
            path(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color.White),
                strokeAlpha = 0.4f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(191.53f, 151.91f)
                curveTo(207.23f, 120.62f, 228.67f, 103.03f, 228.67f, 103.03f)
            }
        }.build()

        return _Empty
    }

@Suppress("ObjectPropertyName")
private var _Empty: ImageVector? = null
