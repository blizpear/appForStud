package com.example.testapp.createRequestScreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testapp.databinding.FragmentAllRequestBinding
import com.example.testapp.databinding.FragmentCreateRequestBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateRequestFragment : Fragment() {

	companion object {

		fun newInstance() = CreateRequestFragment()
	}

	private var _binding: FragmentCreateRequestBinding? = null
	private val binding: FragmentCreateRequestBinding
		get() = _binding ?: throw  IllegalStateException("Binding не может быть null")

	private val viewModel: CreateRequestViewModel by viewModel()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentCreateRequestBinding.inflate(inflater, container, false)

		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		setListeners()
	}

	private fun setListeners(){
		binding.saveButton.setOnClickListener {
			viewModel.saveRequest(
				binding.name.text.toString(),
				binding.date.text.toString(),
				binding.reason.text.toString()
			)
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}