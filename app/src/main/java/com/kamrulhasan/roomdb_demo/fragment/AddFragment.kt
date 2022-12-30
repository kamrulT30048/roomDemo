package com.kamrulhasan.roomdb_demo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.kamrulhasan.roomdb_demo.R
import com.kamrulhasan.roomdb_demo.databinding.FragmentAddBinding
import com.kamrulhasan.roomdb_demo.model.User
import com.kamrulhasan.roomdb_demo.viewmodel.UserViewModel

class AddFragment : Fragment() {

    private lateinit var viewModel: UserViewModel
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.btnAdd.setOnClickListener {
            addUser()
        }
    }

    private fun addUser() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val age = binding.etAge.text.toString()

        if( firstName.isNotBlank() && lastName.isNotBlank() && age.isNotBlank()){

            val user = User(0, firstName, lastName,  age.toInt())

            viewModel.addUser(user)

            Toast.makeText(
                this.requireContext(),
                "One user added",
                Toast.LENGTH_SHORT
            ).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }else{
            Toast.makeText(
                this.requireContext(),
                "Please fill the form!!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}