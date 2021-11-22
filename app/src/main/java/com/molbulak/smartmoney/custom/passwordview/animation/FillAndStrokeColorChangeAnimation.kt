/*
 * Copyright 2019 Keiju Matsumoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.molbulak.smartmoney.custom.passwordview.animation

import com.molbulak.smartmoney.custom.passwordview.CircleView

internal class FillAndStrokeColorChangeAnimation(
    private val circleView: CircleView
) : ColorChangeAnimation(circleView) {

    override fun getColor(): Int = circleView.getFillAndStrokeCircleColor()

    override fun setColor(color: Int) {
        circleView.setFillAndStrokeCircleColor(color)
    }
}