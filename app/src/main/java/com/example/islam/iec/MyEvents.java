package com.example.islam.iec;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islam.iec.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyEvents extends Fragment {

    private RecyclerView myEventsRecyclerView;
    private EventTicketsAdapter myEventsAdapter;
    private RecyclerView.LayoutManager myEventsLayoutManager;
    ArrayList<EventTicket> myEventsList;

    public MyEvents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_events, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myEventsRecyclerView = (RecyclerView) getView().findViewById(R.id.my_events_rec_view);
        myEventsRecyclerView.setHasFixedSize(true);

        myEventsList = new ArrayList<>();
        myEventsList.add(new EventTicket("Startup Weekend Khartoum", "KF32kDCZ3DXE523D"));
        myEventsList.add(new EventTicket("Startup Grind", "AdgSEd42dVdf43GsdS"));



        // Use linear layout manager
        myEventsLayoutManager = new LinearLayoutManager(getActivity());
        myEventsRecyclerView.setLayoutManager(myEventsLayoutManager);

        // specify an adapter (See also next example)
        myEventsAdapter = new EventTicketsAdapter(getActivity(), myEventsList);
        myEventsRecyclerView.setAdapter(myEventsAdapter);

        myEventsAdapter.addTicket(new EventTicket("Test Added", "Ooh! I like you."));
    }

        public void hideNoTicketsIndicator(){
        TextView textView = (TextView) getView().findViewById(R.id.no_tickets_indicator);
        textView.setVisibility(View.INVISIBLE);
    }
    public void showNoTicketsIndicator(){
        TextView textView = (TextView) getView().findViewById(R.id.no_tickets_indicator);
        textView.setVisibility(View.VISIBLE);
    }

    public void setTickets(ArrayList<EventTicket> eventTickets) {
        Log.i("IEC", "setEvents: Set");
        myEventsAdapter.updateDataSet(eventTickets);
        myEventsAdapter.notifyDataSetChanged();

    }

    public void clearTickets(){
        Log.i("IEC", "clearEvents: Cleared first called");
        myEventsAdapter.clearTickets();
    }


}
