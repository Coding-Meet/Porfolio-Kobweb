package com.coding.meet.screens.projects.components

import androidx.compose.runtime.Composable
import com.coding.meet.models.ProjectCategory
import com.coding.meet.screens.projects.styles.CategoryButtonStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.BackgroundPosition
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundPosition
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div

@Composable
fun ProjectCategorySection(
    selectedCategory : ProjectCategory,
    onCategorySelected : (ProjectCategory) -> Unit
){
    Div(
        attrs = Modifier.fillMaxWidth().display(value = DisplayStyle.Flex)
            .flexWrap(FlexWrap.Wrap)
            .margin(top = 10.px).justifyContent(JustifyContent.Center).toAttrs()
    ) {
        ProjectCategory.entries.forEach { projectCategory ->
            Button(
                attrs = CategoryButtonStyle.toModifier().then(
                    if (projectCategory == selectedCategory) Modifier
                        .boxShadow(0.px, 0.px, 0.3.em, null, rgba(0, 0, 0, 0.25f))
                        .backgroundPosition(BackgroundPosition.of(CSSPosition(0.px)))
                        .color(
                            CustomColor(
                                lightColor = Theme.DarkFontColor,
                                darkColor = Theme.LightFontColor
                            )
                        )
                    else Modifier
                )
                    .margin(10.px).toAttrs {
                        onClick {
                            onCategorySelected(projectCategory)
                        }
                    }
            ) {
                SpanText(
                    text = projectCategory.title,
                )
            }
        }
    }
}