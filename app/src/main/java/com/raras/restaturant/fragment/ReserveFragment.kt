/*
 * Copyright (C) 2016 Miguel Panelo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.raras.restaturant.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.raras.restaturant.R
import com.squareup.picasso.Picasso
import java.util.*

class ReserveFragment : Fragment(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, View.OnClickListener {
    private var mDateTimeEditText: EditText? = null
    private var mContext: Context? = null
    private var mNameEditText: EditText? = null
    private var mContactEditText: EditText? = null
    private var mSizeEditText: EditText? = null
    private var mNameInputLayout: TextInputLayout? = null
    private var mContactInputLayout: TextInputLayout? = null
    private var mSizeInputLayout: TextInputLayout? = null
    private var mDateTimeInputLayout: TextInputLayout? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_reserve, container, false)

        val background = view.findViewById(R.id.reserve_background) as ImageView
        Picasso.with(mContext).load(R.drawable.reserve).into(background)

        mDateTimeEditText = view.findViewById(R.id.reserve_edit_datetime) as EditText
        mNameEditText = view.findViewById(R.id.reserve_edit_name) as EditText
        mContactEditText = view.findViewById(R.id.reserve_edit_contact) as EditText
        mSizeEditText = view.findViewById(R.id.reserve_edit_size) as EditText

        mNameInputLayout = view.findViewById(R.id.reserve_input_name) as TextInputLayout
        mContactInputLayout = view.findViewById(R.id.reserve_input_contact) as TextInputLayout
        mSizeInputLayout = view.findViewById(R.id.reserve_input_size) as TextInputLayout
        mDateTimeInputLayout = view.findViewById(R.id.reserve_input_datetime) as TextInputLayout

        mDateTimeEditText!!.setOnClickListener(this)
        view.findViewById(R.id.reserve_button).setOnClickListener(this)
        return view
    }

    override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        if (!view.isShown) {
            return
        }

        mDateTimeEditText!!
                .setText(monthOfYear.toString()
                .plus("/")
                .plus(dayOfMonth)
                .plus("/")
                .plus(year))

        val timePickerDialog = TimePickerDialog(mContext, this,
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE),
                false)
        timePickerDialog.show()
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        if (!view.isShown) {
            return
        }
        var minuteString = minute.toString()
        if (minute < 10) {
            minuteString = "0" + minute
        }
        mDateTimeEditText!!.append(" | $hourOfDay:$minuteString")
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.reserve_edit_datetime -> {
                val dialog = DatePickerDialog(mContext, this,
                        Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
                dialog.datePicker.minDate = Calendar.getInstance().timeInMillis - 1000
                dialog.setTitle("")

                dialog.show()
            }
            R.id.reserve_button -> {
                var hasError = false
                if (TextUtils.isEmpty(mNameEditText!!.text)) {
                    mNameInputLayout!!.error = ERROR_MSG
                    hasError = true
                }
                if (TextUtils.isEmpty(mContactEditText!!.text)) {
                    mContactInputLayout!!.error = ERROR_MSG
                    hasError = true
                }
                if (TextUtils.isEmpty(mSizeEditText!!.text)) {
                    mSizeInputLayout!!.error = ERROR_MSG
                    hasError = true
                }
                if (TextUtils.isEmpty(mDateTimeEditText!!.text)) {
                    mDateTimeInputLayout!!.error = ERROR_MSG
                    hasError = true
                }
                if (!hasError) {
                    mNameEditText!!.setText("")
                    mContactEditText!!.setText("")
                    mSizeEditText!!.setText("")
                    mDateTimeEditText!!.setText("")
                    mNameInputLayout!!.error = ""
                    mContactInputLayout!!.error = ""
                    mSizeInputLayout!!.error = ""
                    mDateTimeInputLayout!!.error = ""
                    Toast.makeText(mContext, "Reservation Booked! Thanks!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    companion object {

        private val ERROR_MSG = "Required field"
    }
}
