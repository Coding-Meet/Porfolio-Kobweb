package com.coding.meet.screens.projects.components

import androidx.compose.runtime.Composable
import com.coding.meet.models.ProjectCategory
import com.coding.meet.screens.projects.styles.CategoryButtonStyle
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div

@Composable
fun ProjectCategorySection(
    selectedCategory: ProjectCategory,
    onCategorySelected: (ProjectCategory) -> Unit
) {
    Div(
        attrs = Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
            .flexWrap(FlexWrap.Wrap)
            .gap(8.px)
            .margin(top = 24.px, bottom = 20.px)
            .justifyContent(JustifyContent.Center)
            .toAttrs()
    ) {
        ProjectCategory.entries.forEach { projectCategory ->
            val isSelected = projectCategory == selectedCategory
            Button(
                attrs = CategoryButtonStyle.toModifier()
                    .then(
                        if (isSelected) Modifier
                            .backgroundColor(Theme.Primary.color)
                            .color(Colors.White)
                            .border(1.px, LineStyle.Solid, Theme.Primary.color)
                            .boxShadow(0.px, 4.px, 14.px, null, rgba(16, 185, 129, 0.4))
                            .fontWeight(FontWeight.SemiBold)
                        else Modifier
                    )
                    .toAttrs {
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