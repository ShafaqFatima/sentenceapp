package com.digipod.sentenceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.digipod.sentenceapp.databinding.FragmentFirstBinding
import com.digipod.sentenceapp.model.CounterViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val counterViewModel: CounterViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submit.setOnClickListener { onSubmit() }
        binding.Clear.setOnClickListener { onClear() }
        counterViewModel.currentVowelCount.observe(
            viewLifecycleOwner
        )
        { newVowelCount ->
            binding.vowelsCount.text = getString(R.string.vowel_count, newVowelCount)
        }
        counterViewModel.currentSpaceCount.observe(
            viewLifecycleOwner
        )
        { newSpaceCount ->
            binding.spaceCount.text = getString(R.string.space_count, newSpaceCount)
        }
        counterViewModel.currentWordCount.observe(
            viewLifecycleOwner
        )
        { newWordCount ->
            binding.wordCount.text = getString(R.string.word_count, newWordCount)
        }
        counterViewModel.currentCharCount.observe(
            viewLifecycleOwner
        )
        { newCharCount ->
            binding.charCount.text = getString(R.string.char_count, newCharCount)
        }
        counterViewModel.currentSPCharCount.observe(
            viewLifecycleOwner
        )
        { newSPCharCount ->
            binding.spcharCount.text = getString(R.string.spchar_count, newSPCharCount)
        }
    }


     private fun onSubmit(){
         val sentence = binding.textInputEditText.text.toString()
         counterViewModel.counter(sentence)
     }
     private fun onClear()
     {
         counterViewModel.reinitializeData()
     }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}