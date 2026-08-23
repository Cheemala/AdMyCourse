package com.cheemala.addmycourse.data.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.cheemala.addmycourse.util.AppConstant.APP_PREFS_NAME

val Context.datastore by preferencesDataStore(name = APP_PREFS_NAME)