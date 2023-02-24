package com.example.workout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class WorkoutListFragment extends ListFragment {

    private Listener listener ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String []names = new String[Workout.workouts.length];
        for (int i = 0 ; i < names.length ; i++){
            names[i] = Workout.workouts[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, names);
        /*1st parameter :
                        we use inflater.getContext () because fragment is not subclass for activity
                        , it acts like this
          2nd parameter : the layout
          3rd parameter : the array which bindes wuth the list in the fragment
        */
        setListAdapter(adapter);

        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

                            /*We need to save a reference to the activity WorkoutListFragment
                            gets attached to. This activity will implement the Listener
                            interface, so we’ll add the following private variable to
                            WorkoutListFragment*/
    @Override
    public void onAttach(Context context) {// We’ll use this method to set the value of the listener

        super.onAttach(context);
        this.listener = (Listener) context;
    }


    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        if (listener != null) {
            listener.itemClicked((int) id);
        }
    }
}