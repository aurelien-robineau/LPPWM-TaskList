package com.lppwm.tasklist.ui.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.lppwm.tasklist.R;
import com.lppwm.tasklist.models.TaskModel;

import java.util.Date;

public class CreateTaskTab extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View root = inflater.inflate(R.layout.create_task, container, false);

        Button createTaskButton = (Button) root.findViewById(R.id.create_task_button);
        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView titleInput = (TextView) root.findViewById(R.id.task_title_input);
                DatePicker dateInput = (DatePicker) root.findViewById(R.id.task_date_input);

                String title = titleInput.getText().toString();
                Date date = new Date(dateInput.getYear(), dateInput.getMonth(), dateInput.getDayOfMonth());

                TaskModel task = new TaskModel(title, date);
                TaskListTab.getInstance().addTask(task);
//                PlanningTab.getInstance().addEvent(task);

                TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);
                tabLayout.getTabAt(0).select();
            }
        });

        return root;
    }
}
