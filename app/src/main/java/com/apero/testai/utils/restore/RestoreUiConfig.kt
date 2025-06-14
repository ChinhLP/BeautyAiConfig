package com.apero.testai.utils.restore

import com.apero.testai.pref.SharedPref
import com.apero.restore.api.config.ui.VslRestoreUiConfig

class RestoreUiConfig : VslRestoreUiConfig {
    override val numberShowDialogServiceRestoreError: Int
        get() = SharedPref.getInstance().numberShowDialogServiceError
} 