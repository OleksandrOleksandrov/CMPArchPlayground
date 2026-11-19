package com.oleksandrov.cmp.arch.playground.loading.screen.composable

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object Empty

val Empty.EmptyImage: ImageVector
    get() {
        if (_EmptyImage != null) {
            return _EmptyImage!!
        }
        _EmptyImage = ImageVector.Builder(
            name = "EmptyImage",
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
                fillAlpha = 0.55f,
                strokeAlpha = 0.55f
            ) {
                moveTo(115f, 115f)
                quadTo(115f, 120f, 110f, 120f)
                quadTo(115f, 120f, 115f, 125f)
                quadTo(115f, 120f, 120f, 120f)
                quadTo(115f, 120f, 115f, 115f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.6f,
                strokeAlpha = 0.6f
            ) {
                moveTo(285f, 275f)
                quadTo(285f, 280f, 280f, 280f)
                quadTo(285f, 280f, 285f, 285f)
                quadTo(285f, 280f, 290f, 280f)
                quadTo(285f, 280f, 285f, 275f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.45f,
                strokeAlpha = 0.45f
            ) {
                moveTo(290f, 125f)
                quadTo(290f, 129f, 286f, 129f)
                quadTo(290f, 129f, 290f, 133f)
                quadTo(290f, 129f, 294f, 129f)
                quadTo(290f, 129f, 290f, 125f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f
            ) {
                moveTo(105f, 265f)
                quadTo(105f, 268f, 102f, 268f)
                quadTo(105f, 268f, 105f, 271f)
                quadTo(105f, 268f, 108f, 268f)
                quadTo(105f, 268f, 105f, 265f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f
            ) {
                moveTo(170f, 95f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
            path(
                fill = SolidColor(Color(0xFF6C727E)),
                fillAlpha = 0.35f,
                strokeAlpha = 0.35f
            ) {
                moveTo(235f, 305f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
            group(
                clipPathData = PathData {
                    moveTo(200f, 200f)
                    moveToRelative(-180f, 0f)
                    arcToRelative(180f, 180f, 0f, isMoreThanHalf = true, isPositiveArc = true, 360f, 0f)
                    arcToRelative(180f, 180f, 0f, isMoreThanHalf = true, isPositiveArc = true, -360f, 0f)
                }
            ) {
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFF7A808C),
                            0.5f to Color(0xFF4A4E57),
                            1f to Color(0xFF2E323B)
                        ),
                        start = Offset(10f, 215f),
                        end = Offset(125f, 285f)
                    ),
                    strokeLineWidth = 14f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(10f, 285f)
                    curveTo(65f, 285f, 75f, 215f, 125f, 215f)
                }
                path(
                    fillAlpha = 0.35f,
                    stroke = SolidColor(Color(0xFF888E99)),
                    strokeAlpha = 0.35f,
                    strokeLineWidth = 2f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(10f, 285f)
                    curveTo(65f, 285f, 75f, 215f, 125f, 215f)
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFF7A808C),
                            0.5f to Color(0xFF4A4E57),
                            1f to Color(0xFF2E323B)
                        ),
                        start = Offset(275f, 115f),
                        end = Offset(390f, 185f)
                    ),
                    strokeLineWidth = 14f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(390f, 115f)
                    curveTo(335f, 115f, 325f, 185f, 275f, 185f)
                }
                path(
                    fillAlpha = 0.35f,
                    stroke = SolidColor(Color(0xFF888E99)),
                    strokeAlpha = 0.35f,
                    strokeLineWidth = 2f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(390f, 115f)
                    curveTo(335f, 115f, 325f, 185f, 275f, 185f)
                }
                path(fill = SolidColor(Color(0xFF32353B))) {
                    moveTo(118.17f, 208.1f)
                    lineTo(125.93f, 206.17f)
                    arcTo(4f, 4f, 88.67f, isMoreThanHalf = false, isPositiveArc = true, 130.78f, 209.08f)
                    lineTo(134.17f, 222.66f)
                    arcTo(4f, 4f, 54.56f, isMoreThanHalf = false, isPositiveArc = true, 131.26f, 227.51f)
                    lineTo(123.49f, 229.45f)
                    arcTo(4f, 4f, 96.85f, isMoreThanHalf = false, isPositiveArc = true, 118.64f, 226.53f)
                    lineTo(115.26f, 212.95f)
                    arcTo(4f, 4f, 96.85f, isMoreThanHalf = false, isPositiveArc = true, 118.17f, 208.1f)
                    close()
                }
                path(
                    fill = SolidColor(Color.Black),
                    stroke = SolidColor(Color(0xFF1E2026)),
                    strokeLineWidth = 2f
                ) {
                    moveTo(120.11f, 207.62f)
                    lineTo(125.43f, 228.96f)
                }
                path(
                    fill = SolidColor(Color.Black),
                    stroke = SolidColor(Color(0xFF1E2026)),
                    strokeLineWidth = 2f
                ) {
                    moveTo(124.96f, 206.41f)
                    lineTo(130.28f, 227.75f)
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFF6A707C),
                            0.5f to Color(0xFF4A4E57),
                            1f to Color(0xFF2B2E36)
                        ),
                        start = Offset(127.45f, 191.45f),
                        end = Offset(127.45f, 232.55f)
                    ),
                    stroke = SolidColor(Color(0xFF7A808C)),
                    strokeLineWidth = 1.5f
                ) {
                    moveTo(132f, 197.44f)
                    lineTo(155.29f, 191.63f)
                    arcTo(6f, 6f, 120.59f, isMoreThanHalf = false, isPositiveArc = true, 162.56f, 196f)
                    lineTo(168.37f, 219.29f)
                    arcTo(6f, 6f, 71.58f, isMoreThanHalf = false, isPositiveArc = true, 164f, 226.56f)
                    lineTo(140.71f, 232.37f)
                    arcTo(6f, 6f, 48.38f, isMoreThanHalf = false, isPositiveArc = true, 133.44f, 228f)
                    lineTo(127.63f, 204.71f)
                    arcTo(6f, 6f, 68.17f, isMoreThanHalf = false, isPositiveArc = true, 132f, 197.44f)
                    close()
                }
                path(
                    fill = SolidColor(Color.Black),
                    stroke = SolidColor(Color(0xFF2B2E36)),
                    strokeLineWidth = 2.5f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(137.82f, 204.23f)
                    lineTo(142.66f, 223.64f)
                }
                path(
                    fill = SolidColor(Color.Black),
                    stroke = SolidColor(Color(0xFF2B2E36)),
                    strokeLineWidth = 2.5f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(144.61f, 202.54f)
                    lineTo(149.45f, 221.94f)
                }
                path(
                    fill = SolidColor(Color.Black),
                    stroke = SolidColor(Color(0xFF2B2E36)),
                    strokeLineWidth = 2.5f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(151.4f, 200.85f)
                    lineTo(156.24f, 220.25f)
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFE8EAEF),
                            0.45f to Color(0xFFC4C9D4),
                            0.85f to Color(0xFF888E99),
                            1f to Color(0xFF5A606B)
                        ),
                        start = Offset(163.12f, 193.42f),
                        end = Offset(163.12f, 201.51f)
                    )
                ) {
                    moveTo(164.26f, 196.61f)
                    lineTo(176.87f, 193.46f)
                    arcTo(1.5f, 1.5f, 121.03f, isMoreThanHalf = false, isPositiveArc = true, 178.69f, 194.56f)
                    lineTo(179.18f, 196.5f)
                    arcTo(1.5f, 1.5f, 129.66f, isMoreThanHalf = false, isPositiveArc = true, 178.08f, 198.32f)
                    lineTo(165.47f, 201.46f)
                    arcTo(1.5f, 1.5f, 129.66f, isMoreThanHalf = false, isPositiveArc = true, 163.65f, 200.37f)
                    lineTo(163.17f, 198.43f)
                    arcTo(1.5f, 1.5f, 124.53f, isMoreThanHalf = false, isPositiveArc = true, 164.26f, 196.61f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFE8EAEF),
                            0.45f to Color(0xFFC4C9D4),
                            0.85f to Color(0xFF888E99),
                            1f to Color(0xFF5A606B)
                        ),
                        start = Offset(167.23f, 209.92f),
                        end = Offset(167.23f, 218f)
                    )
                ) {
                    moveTo(168.37f, 213.1f)
                    lineTo(180.99f, 209.96f)
                    arcTo(1.5f, 1.5f, 121.12f, isMoreThanHalf = false, isPositiveArc = true, 182.8f, 211.05f)
                    lineTo(183.29f, 212.99f)
                    arcTo(1.5f, 1.5f, 88.77f, isMoreThanHalf = false, isPositiveArc = true, 182.2f, 214.81f)
                    lineTo(169.58f, 217.96f)
                    arcTo(1.5f, 1.5f, 121.12f, isMoreThanHalf = false, isPositiveArc = true, 167.76f, 216.86f)
                    lineTo(167.28f, 214.92f)
                    arcTo(1.5f, 1.5f, 129.66f, isMoreThanHalf = false, isPositiveArc = true, 168.37f, 213.1f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF32353B))) {
                    moveTo(268.74f, 172.49f)
                    lineTo(276.51f, 170.55f)
                    arcTo(4f, 4f, 49.51f, isMoreThanHalf = false, isPositiveArc = true, 281.36f, 173.47f)
                    lineTo(284.74f, 187.05f)
                    arcTo(4f, 4f, 130.5f, isMoreThanHalf = false, isPositiveArc = true, 281.83f, 191.9f)
                    lineTo(274.07f, 193.83f)
                    arcTo(4f, 4f, 63.55f, isMoreThanHalf = false, isPositiveArc = true, 269.22f, 190.92f)
                    lineTo(265.83f, 177.34f)
                    arcTo(4f, 4f, 63.55f, isMoreThanHalf = false, isPositiveArc = true, 268.74f, 172.49f)
                    close()
                }
                path(
                    fill = SolidColor(Color.Black),
                    stroke = SolidColor(Color(0xFF1E2026)),
                    strokeLineWidth = 2f
                ) {
                    moveTo(269.72f, 172.25f)
                    lineTo(275.04f, 193.59f)
                }
                path(
                    fill = SolidColor(Color.Black),
                    stroke = SolidColor(Color(0xFF1E2026)),
                    strokeLineWidth = 2f
                ) {
                    moveTo(274.57f, 171.04f)
                    lineTo(279.89f, 192.38f)
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFE8EAEF),
                            0.45f to Color(0xFFC4C9D4),
                            0.85f to Color(0xFF888E99),
                            1f to Color(0xFF5A606B)
                        ),
                        start = Offset(231.45f, 167.45f),
                        end = Offset(231.45f, 208.55f)
                    )
                ) {
                    moveTo(236f, 173.44f)
                    lineTo(259.29f, 167.63f)
                    arcTo(6f, 6f, 63f, isMoreThanHalf = false, isPositiveArc = true, 266.56f, 172f)
                    lineTo(272.37f, 195.29f)
                    arcTo(6f, 6f, 84.33f, isMoreThanHalf = false, isPositiveArc = true, 268f, 202.56f)
                    lineTo(244.71f, 208.37f)
                    arcTo(6f, 6f, 48.38f, isMoreThanHalf = false, isPositiveArc = true, 237.44f, 204f)
                    lineTo(231.63f, 180.71f)
                    arcTo(6f, 6f, 68.17f, isMoreThanHalf = false, isPositiveArc = true, 236f, 173.44f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFF6A707C),
                            0.5f to Color(0xFF4A4E57),
                            1f to Color(0xFF2B2E36)
                        ),
                        start = Offset(227.45f, 177.74f),
                        end = Offset(227.45f, 207.45f)
                    )
                ) {
                    moveTo(228.97f, 178.28f)
                    lineTo(230.91f, 177.8f)
                    arcTo(2f, 2f, 120.84f, isMoreThanHalf = false, isPositiveArc = true, 233.33f, 179.26f)
                    lineTo(239.62f, 204.48f)
                    arcTo(2f, 2f, 121.25f, isMoreThanHalf = false, isPositiveArc = true, 238.16f, 206.91f)
                    lineTo(236.22f, 207.39f)
                    arcTo(2f, 2f, 113.18f, isMoreThanHalf = false, isPositiveArc = true, 233.8f, 205.94f)
                    lineTo(227.51f, 180.71f)
                    arcTo(2f, 2f, 129.19f, isMoreThanHalf = false, isPositiveArc = true, 228.97f, 178.28f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF4A4E57))) {
                    moveTo(254.19f, 180.24f)
                    moveToRelative(-1.94f, 0.48f)
                    arcToRelative(2f, 2f, 70.06f, isMoreThanHalf = true, isPositiveArc = true, 3.88f, -0.97f)
                    arcToRelative(2f, 2f, 70.06f, isMoreThanHalf = true, isPositiveArc = true, -3.88f, 0.97f)
                }
                path(fill = SolidColor(Color(0xFF4A4E57))) {
                    moveTo(257.57f, 193.82f)
                    moveToRelative(-1.94f, 0.48f)
                    arcToRelative(2f, 2f, 45.95f, isMoreThanHalf = true, isPositiveArc = true, 3.88f, -0.97f)
                    arcToRelative(2f, 2f, 45.95f, isMoreThanHalf = true, isPositiveArc = true, -3.88f, 0.97f)
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 0.6f,
                    stroke = SolidColor(Color(0xFF6C727E)),
                    strokeAlpha = 0.6f,
                    strokeLineWidth = 2f
                ) {
                    moveTo(184f, 204f)
                    lineTo(216f, 196f)
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 0.85f,
                    stroke = SolidColor(Color(0xFFD0D4DC)),
                    strokeAlpha = 0.85f,
                    strokeLineWidth = 2.5f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(194f, 182f)
                    lineTo(189f, 172f)
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 0.65f,
                    stroke = SolidColor(Color(0xFF888E99)),
                    strokeAlpha = 0.65f,
                    strokeLineWidth = 2f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(205f, 180f)
                    lineTo(209f, 170f)
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 0.65f,
                    stroke = SolidColor(Color(0xFF888E99)),
                    strokeAlpha = 0.65f,
                    strokeLineWidth = 2f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(195f, 220f)
                    lineTo(191f, 230f)
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 0.85f,
                    stroke = SolidColor(Color(0xFFD0D4DC)),
                    strokeAlpha = 0.85f,
                    strokeLineWidth = 2.5f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(206f, 218f)
                    lineTo(211f, 228f)
                }
            }
        }.build()

        return _EmptyImage!!
    }

@Suppress("ObjectPropertyName")
private var _EmptyImage: ImageVector? = null
