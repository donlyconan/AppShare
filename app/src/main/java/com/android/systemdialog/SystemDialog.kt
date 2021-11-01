package com.android.systemdialog

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.Menu
import android.view.View


class SystemDialog(context: Context) : Dialog(context, R.style.SystemDialog) {
    
    companion object {
        val TAG = SystemDialog::class.java.simpleName
    }
    
    init  {
        setContentView(R.layout.fragment_first)
        Log.d(TAG, "Init: ")
        
        setOnShowListener {
            Log.d(TAG, "setOnShowListener: ")
        }

    }

    override fun onCreatePanelView(featureId: Int): View? {
        return super.onCreatePanelView(featureId)
        Log.d(TAG, "onCreatePanelView: ")
    }

    override fun onPreparePanel(featureId: Int, view: View?, menu: Menu): Boolean {
        return super.onPreparePanel(featureId, view, menu)
        Log.d(TAG, "onPreparePanel: ")
    }
    
}