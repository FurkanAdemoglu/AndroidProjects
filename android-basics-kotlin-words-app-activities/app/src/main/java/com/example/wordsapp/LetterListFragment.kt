package com.example.wordsapp

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentLetterListBinding

/**
 * INITIALIZED: A new instance of the fragment has been instantiated.
CREATED: The first fragment lifecycle methods are called. During this state, the view associated with the fragment is also created.
STARTED: The fragment is visible onscreen but does not have "focus", meaning it can't respond to user input.
RESUMED: The fragment is visible and has focus.
DESTROYED: The fragment object has been de-instantiated.
 */

class LetterListFragment : Fragment() {

    private var _binding: FragmentLetterListBinding? = null
    private var isLinearLayoutManager = true
    private val binding get() = _binding!!//=>Here, get() means this property is "get-only". That means you can get the value, but once assigned (as it is here), you can't assign it to something else.
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        chooseLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    private fun chooseLayout() {
        when (isLinearLayoutManager) {
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = LetterAdapter()
            }
            false -> {
                recyclerView.layoutManager = GridLayoutManager(context, 4)
                recyclerView.adapter = LetterAdapter()
            }
        }
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
//Note: requireContext() returns the Context this fragment is currently associated with.

/**
 * onCreate(): The fragment has been instantiated and is in the CREATED state. However, its corresponding view has not been created yet.
onCreateView(): This method is where you inflate the layout. The fragment has entered the CREATED state.
onViewCreated(): This is called after the view is created. In this method, you would typically bind specific views to properties by calling findViewById().
onStart(): The fragment has entered the STARTED state.
onResume(): The fragment has entered the RESUMED state and now has focus (can respond to user input).
onPause(): The fragment has re-entered the STARTED state. The UI is visible to the user
onStop(): The fragment has re-entered the CREATED state. The object is instantiated but is no longer presented on screen.
onDestroyView(): Called right before the fragment enters the DESTROYED state. The view has already been removed from memory, but the fragment object still exists.
onDestroy(): The fragment enters the DESTROYED state.
 */