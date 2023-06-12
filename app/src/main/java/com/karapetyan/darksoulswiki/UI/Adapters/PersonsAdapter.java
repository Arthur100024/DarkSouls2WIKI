package com.karapetyan.darksoulswiki.UI.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.karapetyan.darksoulswiki.R;
import com.karapetyan.darksoulswiki.UI.Data.Models.PersonsModel;
import com.karapetyan.darksoulswiki.UI.Views.NavigationActivity.NeededPersonFragment;

import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<PersonsModel> persons;
    private Context context;

    Bundle bundle;

    public PersonsAdapter(Context context, List<PersonsModel> persons) {
        this.persons = persons;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_persons, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonsModel model = persons.get(position);
        holder.namePersonsList.setText(model.getName());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("name", String.valueOf(holder.namePersonsList.getText()));
                replaceFragment(new NeededPersonFragment());
            }
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView namePersonsList;
        Button button;

        public ViewHolder(View view) {
            super(view);
            namePersonsList = view.findViewById(R.id.namePersonsList);
            button = view.findViewById(R.id.applyBtn);
        }
    }

    public void setPersons(List<PersonsModel> persons){
        this.persons = persons;
        notifyDataSetChanged();
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fragment.setArguments(bundle);
        ft.replace(R.id.frameNavigation, fragment);
        ft.commit();
    }
}
