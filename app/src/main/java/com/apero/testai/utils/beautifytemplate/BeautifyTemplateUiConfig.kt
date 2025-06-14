package com.apero.testai.utils.beautifytemplate

import com.apero.beautify_template.api.config.ui.VslBeautifyTemplateUiConfig
import com.apero.testai.pref.SharedPref

class BeautifyTemplateUiConfig : VslBeautifyTemplateUiConfig {
    override val numberShowDialogServiceBeautifyTemplateError: Int
        get() = SharedPref.getInstance().numberShowDialogServiceError
} 