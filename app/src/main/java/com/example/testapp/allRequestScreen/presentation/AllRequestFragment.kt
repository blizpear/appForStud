package com.example.testapp.allRequestScreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.allRequestScreen.presentation.recycler.AllRequestAdapter
import com.example.testapp.databinding.FragmentAllRequestBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllRequestFragment : Fragment() {

	companion object {

		fun newInstance() = AllRequestFragment()
	}

	//для доступа к айдишкам из xml
	private var _binding: FragmentAllRequestBinding? = null
	private val binding: FragmentAllRequestBinding
		get() = _binding ?: throw IllegalStateException("Binding не может быть null")

	private val viewModel: AllRequestViewModel by viewModel()

	private lateinit var requestAdapter: AllRequestAdapter

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		_binding = FragmentAllRequestBinding.inflate(inflater, container, false)

		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		setAdapter()
		setListeners()
		setObservers()
	}

	//создаем и дает вьюхе адаптер
	private fun setAdapter() {
		requestAdapter = AllRequestAdapter()
		binding.content.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
		binding.content.adapter = requestAdapter
	}

	//слушатель на кнопку для перехода на другой экран
	private fun setListeners() {
		binding.addButton.setOnClickListener {
			viewModel.navigateToAddScreen()
		}
	}

	//подписываемся на данные с реквестами из бд и отдаем их адаптеру для рисовки нужных холдером
	private fun setObservers() {
		viewModel.content.observe(viewLifecycleOwner) {
			requestAdapter.submitList(it)
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}