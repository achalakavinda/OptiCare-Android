package com.opensource.eye.opticare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.opensource.eye.opticare.Adapters.ReminderPatientListAdapter;
import com.opensource.eye.opticare.Models.ReminderPatientModel;

import java.util.ArrayList;
import java.util.List;

public class PatientReminderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<ReminderPatientModel> input = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_reminder);

        layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        recyclerView.setLayoutManager(layoutManager);

        ReminderPatientModel Model = new ReminderPatientModel("1","2019-02-03","08:00 AM","","","","","","");
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        input.add(Model);
        mAdapter = new ReminderPatientListAdapter(input);
        recyclerView.setAdapter(mAdapter);

    }
}
