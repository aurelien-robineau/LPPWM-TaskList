package com.lppwm.tasklist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;

import com.lppwm.tasklist.MainActivity;
import com.lppwm.tasklist.R;
import com.lppwm.tasklist.models.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {
    private List<TaskModel> taskList = new ArrayList<>();

    private MainActivity activity;

    public TaskListAdapter(MainActivity activity) {
        this.activity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);

        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        TaskModel item = taskList.get(position);
        holder.checkBox.setText(item.getTitle());
        holder.checkBox.setChecked(item.isDone());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskList.remove(item);
                notifyDataSetChanged();
            }
        });
    }

    public int getItemCount() {
        return taskList.size();
    }

    public void setTasks(List<TaskModel> taskList) {
        this.taskList = taskList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        ImageButton deleteButton;

        ViewHolder(View view) {
            super(view);
            checkBox = view.findViewById(R.id.task_check_box);
            deleteButton = view.findViewById(R.id.task_delete_btn);
        }
    }
}

