package com.lppwm.tasklist.ui.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lppwm.tasklist.MainActivity;
import com.lppwm.tasklist.R;
import com.lppwm.tasklist.adapters.PlanningAdapter;
import com.lppwm.tasklist.models.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class PlanningTab extends Fragment {
    private static PlanningTab instance = null;

    private final MainActivity mActivity;
    private RecyclerView planningRecyclerView;
    private PlanningAdapter planningAdapter;

    private List<TaskModel> eventList;

    public PlanningTab(MainActivity activity) {
        super();
        mActivity = activity;
    }

    public static void setInstance(PlanningTab planningTab) {
        instance = planningTab;
    }

    public static PlanningTab getInstance() {
        return instance;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View root = inflater.inflate(R.layout.planning, container, false);

        eventList = new ArrayList<>();

        planningRecyclerView = root.findViewById(R.id.planning_recycler_view);
        planningRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        planningAdapter = new PlanningAdapter(mActivity);
        planningRecyclerView.setAdapter(planningAdapter);

        return root;
    }

    public void addEvent(TaskModel event) {
        eventList.add(event);
        planningAdapter.setEvents(eventList);
    }
}
