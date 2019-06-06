package com.opensource.eye.opticare.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.opensource.eye.opticare.Models.ReminderPatientModel;
import com.opensource.eye.opticare.R;

import java.util.List;

public class ReminderPatientListAdapter extends RecyclerView.Adapter<ReminderPatientListAdapter.ViewHolder> {

    private List<ReminderPatientModel> values;


    public class ViewHolder extends RecyclerView.ViewHolder {

        public View layout;
        LinearLayout linearLayoutPostItemCard;
        TextView textDate;
        TextView textType;
        TextView textStatus;
        TextView textOptician;
        TextView textNote;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            linearLayoutPostItemCard = v.findViewById(R.id.EventItemCard);

            textDate = v.findViewById(R.id.textDate);
            textType = v.findViewById(R.id.textType);
            textStatus = v.findViewById(R.id.textStatus);
            textOptician = v.findViewById(R.id.textOptician);
            textNote = v.findViewById(R.id.textNote);
        }
    }

    public void add(int position, ReminderPatientModel item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ReminderPatientListAdapter(List<ReminderPatientModel> myDataset)
    {
        values = myDataset;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ReminderPatientListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());

        View v = inflater.inflate(R.layout.recycler_patient_reminder_item, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    private int lastPosition = -1;

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {

        holder.textDate.setText(values.get(position).getDate());
        holder.textType.setText(values.get(position).getType());
        holder.textStatus.setText(values.get(position).getStatus());

        holder.textOptician.setText(values.get(position).getPatient_name());
        holder.textNote.setText(values.get(position).getNote());

        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);

        holder.itemView.startAnimation(animation);
        lastPosition = position;

        holder.linearLayoutPostItemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.EventItemCard:
//                        System.out.println(values.get(position).description);
                        break;
                    default:
                        return;
                }
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

    }
}
