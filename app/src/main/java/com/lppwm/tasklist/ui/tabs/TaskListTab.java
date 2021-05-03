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
import com.lppwm.tasklist.adapters.TaskListAdapter;
import com.lppwm.tasklist.models.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskListTab extends Fragment {
    private static TaskListTab instance = null;

    private final MainActivity mActivity;
    private RecyclerView taskRecyclerView;
    private TaskListAdapter taskAdapter;

    private List<TaskModel> taskList;

    public TaskListTab(MainActivity activity) {
        super();
        mActivity = activity;
    }

    public static void setInstance(TaskListTab taskListTab) {
        instance = taskListTab;
    }

    public static TaskListTab getInstance() {
        return instance;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View root = inflater.inflate(R.layout.task_list, container, false);

        taskList = new ArrayList<>();

        taskRecyclerView = root.findViewById(R.id.task_list_recycler_view);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        taskAdapter = new TaskListAdapter(mActivity);
        taskRecyclerView.setAdapter(taskAdapter);

        return root;
    }

    public void addTask(TaskModel task) {
        taskList.add(task);
        taskAdapter.setTasks(taskList);
    }
}
