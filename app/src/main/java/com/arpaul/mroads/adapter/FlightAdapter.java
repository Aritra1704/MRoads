package com.arpaul.mroads.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arpaul.mroads.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by ARPaul on 10-02-2017.
 */

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.ParentViewHolder> {
    private Context context;
    private ArrayList<String> arrFlight = new ArrayList<>();

    public FlightAdapter(Context context, ArrayList<String> arrFlight) {
        this.context = context;
        this.arrFlight = arrFlight;
    }

    public void refresh(ArrayList<String> arrFlight) {
        this.arrFlight = arrFlight;
        notifyDataSetChanged();
    }

    public ArrayList<String> getFlights() {
        return arrFlight;
    }

    @Override
    public ParentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_flight, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ParentViewHolder holder, final int position) {
//        final String objGeoFenceLocDO = arrFlight.get(position);
//        holder.edtDest.setText(objGeoFenceLocDO);

        holder.edtDest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(arrFlight.size() < (position + 1))
                    arrFlight.add(s.toString());
                else
                    arrFlight.set(position, s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public int getItemCount() {
        if(arrFlight != null)
            return arrFlight.size();

        return 0;
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final EditText edtDest;

        public ParentViewHolder(View view) {
            super(view);
            mView = view;
            edtDest                  = (EditText) view.findViewById(R.id.edtDest);
        }

        @Override
        public String toString() {
            return "";
        }
    }
}
