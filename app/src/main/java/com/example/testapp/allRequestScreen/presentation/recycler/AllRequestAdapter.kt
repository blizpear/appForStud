package com.example.testapp.allRequestScreen.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.testapp.allRequestScreen.domain.Request

class AllRequestAdapter : ListAdapter<Request, RequestHolder>(RequestDiffUtil()) {

	//ресайлер создает кучу холдеров
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestHolder =
		RequestHolder.from(parent)

	//ресайклер дает холдерам контент
	override fun onBindViewHolder(holder: RequestHolder, position: Int) {
		holder.bind(request = getItem(position))
	}

	//штука нужна для сравнения элементов и если они разные - обновить их
	private class RequestDiffUtil(): DiffUtil.ItemCallback<Request>(){

		override fun areContentsTheSame(oldItem: Request, newItem: Request): Boolean =
			oldItem.id == newItem.id

		override fun areItemsTheSame(oldItem: Request, newItem: Request): Boolean =
			oldItem == newItem
	}
}