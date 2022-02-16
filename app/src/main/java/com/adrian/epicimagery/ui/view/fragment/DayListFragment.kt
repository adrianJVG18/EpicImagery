package com.adrian.epicimagery.ui.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrian.epicimagery.R
import com.adrian.epicimagery.databinding.FragmentDayListBinding
import com.adrian.epicimagery.domain.model.dto.DateDto
import com.adrian.epicimagery.domain.usecase.GetDatesUseCase
import com.adrian.epicimagery.ui.adapter.DatesAdapter
import com.adrian.epicimagery.utils.extension.viewBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DayListFragment() : Fragment(R.layout.fragment_day_list) {

    private val binding: FragmentDayListBinding by viewBinding(FragmentDayListBinding::bind)

    private var datesList = MutableLiveData<List<DateDto>>()

    private val datesAdapter: DatesAdapter by lazy {
        DatesAdapter(datesList.value?: ArrayList())
    }

    private val getDatesUseCase: GetDatesUseCase by lazy {
        GetDatesUseCase()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.datesListRecyclerView.adapter = datesAdapter
        binding.datesListRecyclerView.layoutManager = LinearLayoutManager(activity)

        getDatesUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       datesAdapter.updateList(it)
            }, {

            })
    }

}