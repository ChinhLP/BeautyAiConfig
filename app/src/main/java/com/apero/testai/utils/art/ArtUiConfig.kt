package com.apero.testai.utils.art

import com.apero.art.api.config.ui.VslArtUiConfig
import com.apero.art.internal.data.model.StyleCategory

class ArtUiConfig : VslArtUiConfig {
    override val numberShowDialogServiceArtError: Int
        get() = 1
    override val listDataCategory: suspend () -> List<StyleCategory>
        get() = { listOf() }
} 