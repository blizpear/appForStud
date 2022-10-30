package com.example.testapp.allRequestScreen.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.allRequestScreen.domain.Request
import com.example.testapp.databinding.RequestItemBinding

class RequestHolder(
	private val binding: RequestItemBinding
) : RecyclerView.ViewHolder(binding.root) {

	companion object {
		//создаем холдер
		fun from(parent: ViewGroup): RequestHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = RequestItemBinding.inflate(inflater, parent, false)

			return RequestHolder(binding)
		}
	}

	//устанавливаем данные из класса во вьюхи в xml из дата класса
	fun bind(
		request: Request
	){
		binding.name.text = request.name
		binding.date.text = request.date
		binding.reason.text = request.reason
	}
}