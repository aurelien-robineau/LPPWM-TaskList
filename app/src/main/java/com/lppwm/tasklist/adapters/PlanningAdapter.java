package com.lppwm.tasklist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lppwm.tasklist.MainActivity;
import com.lppwm.tasklist.R;
import com.lppwm.tasklist.models.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class PlanningAdapter extends RecyclerView.Adapter<PlanningAdapter.ViewHolder> {
    private List<TaskModel> eventList = new ArrayList<>();

    private MainActivity activity;

    public PlanningAdapter(MainActivity activity) {
        this.activity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_layout, parent, false);

        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        TaskModel item = eventList.get(position);
        holder.date.setText(item.getTitle());
        holder.title.setText(item.getDate().toString());
    }

    public int getItemCount() {
        return eventList.size();
    }

    public void setEvents(List<TaskModel> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        TextView title;

        ViewHolder(View view) {
            super(view);
            date = view.findViewById(R.id.event_date);
            title = view.findViewById(R.id.event_title);
        }
    }
}

